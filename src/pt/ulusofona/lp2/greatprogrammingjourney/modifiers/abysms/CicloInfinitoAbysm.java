package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

public class CicloInfinitoAbysm extends AbstractAbysm {
    public CicloInfinitoAbysm() {
        super();
    }

    @Override AbysmType type() {
        return AbysmType.CICLO_INFINITO;
    }

    @Override
    public String name() {
        return "Ciclo Infinito";
    }
}
