package pt.ulusofona.lp2.greatprogrammingjourney.board;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.Modifier;

public class Slot {
    private Modifier modifier;

    public Slot() {}

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