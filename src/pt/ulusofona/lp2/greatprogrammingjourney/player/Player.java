package pt.ulusofona.lp2.greatprogrammingjourney.player;

import pt.ulusofona.lp2.greatprogrammingjourney.GameManager;
import pt.ulusofona.lp2.greatprogrammingjourney.board.Board;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.Modifier;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.ModifierGroup;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms.AbstractAbysm;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.AbstractTool;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.ToolType;

import java.util.*;

public class Player {
    private static final ArrayList<String> VALID_COLORS = new ArrayList<>(List.of(new String[]{"Purple", "Green", "Brown", "Blue"}));

    private final int id;
    private final String name;
    private final List<String> languages;
    private String color;
    private int position;

    private PlayerState state;
    private ArrayList<Integer> history;
    private HashMap<ToolType, AbstractTool> tools;

    public Player(String[] info) {
        this.id = Integer.parseInt(info[0]);
        this.name = info[1];
        this.languages = Arrays.asList(info[2].split(";"));
        this.color = info[3];
        this.position = 1;

        this.state = PlayerState.PLAYING;
        this.history = new ArrayList<>();
        this.tools = new HashMap<>();

        this.history.add(this.position);
    }

    public int id() {
        return id;
    }

    public String name() { return name; }

    public List<String> languages() {
        return this.languages;
    }

    public String color() {
        return this.color;
    }

    public int position() {
        return position;
    }

    public void setPosition(int slot) {
        this.position = slot;
    }

    public void move(int slots) {
        this.position += slots;
        this.history.add(this.position);
    }

    public PlayerState state() {
        return this.state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public ArrayList<Integer> history() {
        return this.history;
    }

    public HashMap<ToolType, AbstractTool> tools() {
        return this.tools;
    }

    public boolean hasTool(ToolType type) {
        return this.tools.containsKey(type);
    }

    public void addTool(AbstractTool tool) {
        this.tools.put(tool.type(), tool);
    }

    public void removeTool(AbstractTool tool) {
        this.tools.remove(tool.type());
    }

    public String handleModifier(Modifier mod, Board board, HashMap<Integer, Player> players) {
        switch (mod.group()) {
            case ABYSM -> {
                AbstractAbysm abysm = (AbstractAbysm) mod;
                AbstractTool tool = abysm.counter(this.tools());

                if (tool != null) {
                    this.removeTool(tool);
                    return mod.name() + " anulado por " + tool.name();
                }

                return this.triggerAbyss(abysm, board, players);
            }
            case TOOL -> {
                AbstractTool tool = (AbstractTool) mod;
                if (this.hasTool(tool.type())) {
                    return null;
                }

                this.addTool(tool);
                return "Recolheu ferramenta: " + mod.name();
            }
        }

        return null;
    }

    private String triggerAbyss(AbstractAbysm abysm, Board board, HashMap<Integer, Player> players) {
        switch (abysm.type()) {
            case ERRO_SINTAXE -> {
                // update position and log it in history
                this.setPosition(this.position-1);
                this.history.set(this.history.size()-1, this.position);
            }
            case ERRO_LOGICA -> {
                int cur = this.position;
                int prev = this.history.get(this.history.size()-2);

                int back = Math.floorDiv((cur - prev), 2);

                this.setPosition(this.position - back);
                this.history.set(this.history.size()-1, this.position);
            }
            case EXCEPTION -> {
                // update position and log it in history
                this.setPosition(this.position-2);
                this.history.set(this.history.size()-1, this.position);
            }
            case FILE_NOT_FOUND_EXCEPTION -> {
                // update position and log it in history
                this.setPosition(this.position-3);
                this.history.set(this.history.size()-1, this.position);
            }
            case CRASH -> {
                // update position and log it in history
                this.setPosition(1);
                this.history.set(this.history.size()-1, this.position);
            }
            case CODIGO_DUPLICADO -> {
                // update position and log it in history
                this.setPosition(this.history.get(this.history.size()-2));
                this.history.set(this.history.size()-1, this.position);
            }
            case EFEITOS_SECUNDARIOS -> {
                // update position and log it in history
                this.setPosition(this.history.get(this.history.size()-3));
                this.history.set(this.history.size()-1, this.position);
            }
            case BLUE_SCREEN_OF_DEATH -> {
                this.setState(PlayerState.DEFEATED);
            }
            case CICLO_INFINITO -> {
                // todo
                this.setState(PlayerState.TRAPPED);

                for (Player player : players.values()) {
                    if (player.position() == this.position) {
                        player.setState(PlayerState.PLAYING);
                    }
                }
            }
            case SEGMENTATION_FAULT -> {
                int count = 1;
                for (Player player : players.values()) {
                    if (player.position() == this.position) {
                       count++;
                    }
                }

                if (count < 2) {
                    return null;
                }

                for (Player player : players.values()) {
                    if (player.position() == this.position) {
                        player.setPosition(player.position()-3);
                    }
                }
            }
        }

        return abysm.message();
    }

    public static boolean validate(String[] info, HashMap<Integer, Player> players) {
        try {
            int id = Integer.parseInt(info[0]);
            String nome = info[1];
            String color = info[3];

            // invalid id
            if (id <= 0) {
                return false;
            }

            // duplicated id
            if (players.containsKey(id)) {
                return false;
            }

            // empty name
            if (nome.isEmpty()) {
                return false;
            }

            // invalid color
            if (!VALID_COLORS.contains(color)) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        String langs = "No languages";
        if (!this.languages.isEmpty()) {
            String[] langsArr = this.languages.toArray(new String[0]);
            Arrays.sort(langsArr);

            langs = String.join("; ", langsArr);
        }

        String tools = "No tools";
        if (!this.tools.isEmpty()) {
            String[] toolsArr = this.tools.values().stream()
                    .map(AbstractTool::name)
                    .toArray(String[]::new);
            tools = String.join(";", toolsArr);
        }

        String state = switch (this.state) {
            case PLAYING -> "Em Jogo";
            case TRAPPED -> "Preso";
            case DEFEATED -> "Derrotado";
        };

        return this.id + " | " + this.name + " | " + this.position + " | " + tools + " | " + langs + " | " + state;
    }

    public String toStringTools() {
        if (this.tools.isEmpty()) {
            return this.name + " : No tools";
        }

        String[] tools = this.tools.values().stream()
                .map(AbstractTool::name)
                .toArray(String[]::new);

        return this.name + " : " + String.join("; ", tools);
    }

    public String[] toArray() {

        String langs = "No languages";
        if (!this.languages.isEmpty()) {
            String[] langsArr = this.languages.toArray(new String[0]);
            langs = String.join("; ", langsArr);
        }

        String tools = "No tools";
        if (!this.tools.isEmpty()) {
            String[] toolsArr = this.tools.values().stream()
                    .map(AbstractTool::name)
                    .toArray(String[]::new);
            Arrays.sort(toolsArr);
            tools = String.join(";", toolsArr);
        }

        return new String[] {
                String.valueOf(this.id),
                this.name,
                langs,
                this.color,
                String.valueOf(this.position),
                tools
        };
    }
}