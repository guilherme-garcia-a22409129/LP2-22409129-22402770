package pt.ulusofona.lp2.greatprogrammingjourney.board;

import pt.ulusofona.lp2.greatprogrammingjourney.InvalidFileException;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.Modifier;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> toSave() {
        List<String> res = new ArrayList<>();

        for (int i = 1; i <= this.size(); i++) {
            Slot s = this.getSlot(i);
            if (s.hasModifier()) {
                Modifier m = s.getModifier();
                res.add("SLOT=" + i + "|" + m.code());
            }
        }

        return res;
    }

    public void fromSave(String line) throws InvalidFileException {
        try {
            String[] parts = line.substring(5).split("\\|");

            int pos = Integer.parseInt(parts[0]);
            if (pos < 1 || pos > size()) {
                throw new InvalidFileException();
            }

            String code = parts[1];

            Modifier mod = Modifier.fromCode(code);
            if (mod == null) {
                throw new InvalidFileException();
            }

            this.addModifier(mod, pos - 1);

        } catch (Exception e) {
            throw new InvalidFileException();
        }
    }
}
