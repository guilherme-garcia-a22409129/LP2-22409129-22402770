package pt.ulusofona.lp2.greatprogrammingjourney.board;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.Modifier;

public class Slot {
    private final int id;
    private Modifier modifier;

    public Slot(int id) {
        this.id = id;
    }

    public int id() {
        return this.id;
    }

    public boolean hasModifier() {
        return this.modifier != null;
    }

    public Modifier getModifier() {
        return this.modifier;
    }

    public void setModifier(Modifier mod) {
        this.modifier = mod;
    }
}