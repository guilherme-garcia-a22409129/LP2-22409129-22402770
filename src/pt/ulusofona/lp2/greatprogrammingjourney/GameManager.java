package pt.ulusofona.lp2.greatprogrammingjourney;

import pt.ulusofona.lp2.greatprogrammingjourney.board.Board;
import pt.ulusofona.lp2.greatprogrammingjourney.board.Slot;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.Modifier;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.ModifierGroup;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms.AbstractAbysm;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.AbstractTool;
import pt.ulusofona.lp2.greatprogrammingjourney.player.Player;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.spi.AbstractResourceBundleProvider;

public class GameManager {
    private HashMap <Integer, Player> players; // initialize map inside createInitialBoard to avoid persistent data during tests
    private Player winner;
    private Board board;
    private int turns = 0;

    public GameManager() {}

    public boolean createInitialBoard(String[][] playerInfo, int worldSize){
        if (playerInfo.length < 2 || playerInfo.length > 4) {
            return false;
        }

        if (worldSize < playerInfo.length*2) {
            return false;
        }

        players = new HashMap<>();
        board = new Board(worldSize);
        winner = null;
        turns = 1;

        for (String[] j : playerInfo) {
            if (!Player.validate(j, players)) {
                return false;
            }

            Player jogador = new Player(j);
            players.put(jogador.id(), jogador);
        }

        return true;
    }

    public boolean createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) {
        if (playerInfo.length < 2 || playerInfo.length > 4) {
            return false;
        }

        if (worldSize < playerInfo.length*2) {
            return false;
        }

        players = new HashMap<>();
        board = new Board(worldSize);
        winner = null;
        turns = 1;

        // validar jogadores
        for (String[] j : playerInfo) {
            if (!Player.validate(j, players)) {
                return false;
            }

            Player jogador = new Player(j);
            players.put(jogador.id(), jogador);
        }

        // validar modifiers
        for (String[] m : abyssesAndTools) {
            Modifier mod = Modifier.validate(m, worldSize);
            if (mod == null) {
                return false;
            }

            board.addModifier(mod, Integer.parseInt(m[2])-1);
        }

        return true;
    }

    public String getImagePng(int nrSquare) {
        return board.slotImage(nrSquare);
    }

    public String[] getProgrammerInfo(int id){
        Player jogador = players.get(id);
        if (jogador != null) {
            return jogador.toArray();
        }
        return null;
    }

    public String getProgrammerInfoAsStr(int id){
        Player jogador = players.get(id);
        if (jogador != null) {
            return jogador.toString();
        }
        return null;
    }

    public String getProgrammersInfo() {
        String[] infos = players.values().stream()
                .filter(jogador -> !jogador.defeated())
                .map(Player::toStringTools)
                .toArray(String[]::new);

        return String.join(";", infos);
    }

    public String[] getSlotInfo(int slot){
        if (slot < 1 || slot > board.size()) {
            return null;
        }

        String[] res = new String[]{""};
        List<String> ids = new ArrayList<>();

        // grab ids...
        for (Integer id : players.keySet()) {
            if (players.get(id).position() == slot) {
                ids.add(String.valueOf(id));
            }
        }

        res[0] = String.join(",", ids);

        return res;
    }

    public int getCurrentPlayerID(){
        ArrayList<Integer> ids = new ArrayList<>(players.keySet());
        ids.sort(Integer::compareTo);

        int index = (turns -1) % ids.size();

        return ids.get(index);
    }

    public boolean moveCurrentPlayer(int spaces){
        if (spaces < 1 || spaces > 6) {
            return false;
        }

        Player jogador = players.get(getCurrentPlayerID());
        int pos = jogador.position();

        if (pos + spaces > board.size()) {
            spaces = board.size() - pos;
        }

        jogador.move(spaces);

        // set winner
        if (jogador.position() == board.size()) {
            if (winner == null) {
                winner = jogador;
            }
        }

        return true;
    }

    public String reactToAbyssOrTool() {
        Player player = players.get(getCurrentPlayerID());
        Slot slot = board.getSlot(player.position());

        turns++;

        if (!slot.hasModifier()) {
            return null;
        }

        Modifier mod = slot.getModifier();

        switch (mod.group()) {
            case ModifierGroup.ABYSM -> {
                AbstractAbysm abysm = (AbstractAbysm) mod;
                AbstractTool tool = abysm.counter(player.tools());

                if (tool != null) {
                    player.removeTool(tool);
                    return mod.name() + " anulado por " + tool.name();
                }

                // trapp player

                break;
            }
            case ModifierGroup.TOOL -> {
                AbstractTool tool = (AbstractTool) mod;
                if (player.hasTool(tool.type())) {
                    return null;
                }

                player.addTool(tool);
                return "Recolheu ferramenta: " + mod.name();
            }
        }

        return null;
    }

    public boolean gameIsOver(){
        return !getSlotInfo(board.size())[0].isEmpty();
    }

    public ArrayList<String> getGameResults(){
        ArrayList<String> res = new ArrayList<>();

        res.add("THE GREAT PROGRAMMING JOURNEY");
        res.add("");
        res.add("NR. DE TURNOS");
        res.add(String.valueOf(turns));
        res.add("");
        res.add("VENCEDOR");
        res.add(((winner != null) ? winner.name() : ""));
        res.add("");
        res.add("RESTANTES");

        List<Player> rem = new ArrayList<>(players.values());
        if (winner != null) {
            rem.removeIf(v -> v.id() == winner.id());
        }

        rem.sort((a, b) -> {
            int cmp = Integer.compare(b.position(), a.position());
            if (cmp == 0) {
                cmp = a.name().compareToIgnoreCase(b.name());
            }
            return cmp;
        });

        for (Player jogador : rem) {
            res.add(jogador.name() + " " +  jogador.position());
        }

        return res;
    }

    public void loadGame(File file) throws InvalidFileException, FileNotFoundException {

    }

    public boolean saveGame(File file) {
        return false;
    }

    // TODO...
    public JPanel getAuthorsPanel() {
        return new JPanel();
    }

    // TODO...
    public HashMap<String, String> customizeBoard() {
        return new HashMap<>();
    }
}
