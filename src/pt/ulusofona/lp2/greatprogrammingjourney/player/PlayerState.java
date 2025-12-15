package pt.ulusofona.lp2.greatprogrammingjourney.player;

public enum PlayerState {
    PLAYING("Em Jogo"),
    TRAPPED("Preso"),
    DEFEATED("Derrotado");

    private final String label;

    PlayerState(String text) {
        this.label = text;
    }

    @Override
    public String toString() {
        return label;
    }
}