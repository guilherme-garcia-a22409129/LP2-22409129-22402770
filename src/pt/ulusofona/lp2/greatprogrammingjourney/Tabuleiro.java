package pt.ulusofona.lp2.greatprogrammingjourney;

public class Tabuleiro {
    private int tamanho;

    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public String slotImage(int slot) {
        if (slot == 1) {
            return null;
            //return "start.png";
        } else if (slot == this.tamanho) {
            return "glory.png";
        } else if (slot > 0 && slot < this.tamanho) {
            return null;
            //return "normal.png";
        } else {
            return null;
        }
    }
}
