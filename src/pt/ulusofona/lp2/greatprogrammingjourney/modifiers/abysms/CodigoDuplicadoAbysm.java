package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

public class CodigoDuplicadoAbysm extends AbstractAbysm {
    public CodigoDuplicadoAbysm() {
        super();
    }

    @Override AbysmType type() {
        return AbysmType.CODIGO_DUPLICADO;
    }

    @Override
    public String name() {
        return "Código Duplicado";
    }
}
