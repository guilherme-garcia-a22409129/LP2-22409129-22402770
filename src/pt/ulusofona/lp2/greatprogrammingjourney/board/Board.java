package pt.ulusofona.lp2.greatprogrammingjourney.board;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.Modifier;

import java.util.ArrayList;

public class Board {
    private final ArrayList<Slot> slots;

    public Board(int size) {
        this.slots = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            slots.add(new Slot(i));
        }
    }

    public int size() {
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

    public Slot getSlot(int idx) {
        return this.slots.get(idx-1);
    }

    public void addModifier(Modifier mod, int pos) {
        this.slots.get(pos).setModifier(mod);
    }
}
