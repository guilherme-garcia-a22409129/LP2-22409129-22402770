package pt.ulusofona.lp2.greatprogrammingjourney.player;

import pt.ulusofona.lp2.greatprogrammingjourney.GameManager;
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
        this.tools = new HashMap<>();
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

    public boolean hasTool(ToolType type) {
        return this.tools.containsKey(type);
    }

    public HashMap<ToolType, AbstractTool> tools() {
        return this.tools;
    }

    public void addTool(AbstractTool tool) {
        this.tools.put(tool.type(), tool);
    }

    public void removeTool(AbstractTool tool) {
        this.tools.remove(tool.type());
    }

    public void move(int slots) {
        this.position += slots;
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
        String[] arr = this.languages.toArray(new String[0]);
        Arrays.sort(arr);
        return this.id + " | " + this.name + " | " + this.position + " | " + String.join("; ", arr) + " | " + (this.state == PlayerState.DEFEATED ? "Derrotado" : "Em Jogo");
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
        return new String[] {String.valueOf(this.id), this.name, String.join(";", this.languages), this.color, String.valueOf(this.position)};
    }
}