package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

public class EfeitosSecundariosAbysm extends AbstractAbysm {
    public EfeitosSecundariosAbysm() {
        super();
    }

    @Override AbysmType type() {
        return AbysmType.EFEITOS_SECUNDARIOS;
    }

    @Override
    public String name() {
        return "Efeitos Secundários";
    }
}
