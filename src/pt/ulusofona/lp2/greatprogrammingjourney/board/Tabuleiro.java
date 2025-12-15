package pt.ulusofona.lp2.greatprogrammingjourney.board;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.Modifier;

import java.util.ArrayList;

public class Tabuleiro {
    private ArrayList<Slot> slots;

    public Tabuleiro(int tamanho) {
        this.slots = new ArrayList<>(tamanho);

        for (int i = 0; i < tamanho; i++) {
            slots.add(new Slot(i));
        }
    }

    public int tamanho() {
        return this.slots.size();
    }

    public String slotImage(int slot) {
        if (slot == 1) {
            return null;
            //return "start.png";
        } else if (slot == this.slots.size()) {
            return "glory.png";
        } else if (slot > 0 && slot < this.slots.size()) {
            return null;
            //return "normal.png";
        } else {
            return null;
        }
    }

    public void addModifier(Modifier mod, int pos) {
        this.slots.get(pos).setModifier(mod);
    }
}
