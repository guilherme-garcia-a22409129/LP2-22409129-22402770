package pt.ulusofona.lp2.greatprogrammingjourney;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.Modifier;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.ModifierType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Jogador {
    private static final ArrayList<String> VALID_COLORS = new ArrayList<>(List.of(new String[]{"Purple", "Green", "Brown", "Blue"}));

    private final int id;
    private final String nome;
    private final List<String> linguagens;
    private String cor;
    private int posicao;
    private boolean derrotado;
    private ArrayList<Modifier> modifiers;

    public Jogador(String[] info) {
        this.id = Integer.parseInt(info[0]);
        this.nome = info[1];
        this.linguagens = Arrays.asList(info[2].split(";"));
        this.cor = info[3];
        this.posicao = 1;
        this.derrotado = false;
        this.modifiers = new ArrayList<>();
    }

    public int id() {
        return id;
    }

    public String nome() { return nome; }

    public List<String> linguagens() {
        return this.linguagens;
    }

    public String cor() {
        return this.cor;
    }

    public int posicao() {
        return posicao;
    }

    public boolean derrotado() {
        return this.derrotado;
    }

    public void avanca(int casas) {
        this.posicao += casas;
    }

    public static boolean valida(String[] info) {
        try {
            int id = Integer.parseInt(info[0]);
            String nome = info[1];
            String color = info[3];

            // invalid id
            if (id <= 0) {
                return false;
            }

            // duplicated id
            if (GameManager.jogadores.containsKey(id)) {
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
        String[] arr = this.linguagens.toArray(new String[0]);
        Arrays.sort(arr);
        return this.id + " | " + this.nome + " | " + this.posicao + " | " + String.join("; ", arr) + " | " + (this.derrotado ? "Derrotado" : "Em Jogo");
    }

    public String toStringTools() {
        if (this.modifiers.isEmpty()) {
            return this.nome + " : No tools";
        }

        String[] tools = this.modifiers.stream()
                .filter(m -> m.type() == ModifierType.TOOL)
                .map(Modifier::name)
                .toArray(String[]::new);

        return this.nome + " : " + String.join("; ", tools);
    }

    public String[] toArray() {
        return new String[] {String.valueOf(this.id), this.nome, String.join(";", this.linguagens), this.cor, String.valueOf(this.posicao)};
    }
}
