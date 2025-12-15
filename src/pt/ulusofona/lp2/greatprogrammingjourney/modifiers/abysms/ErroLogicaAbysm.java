package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

public class ErroLogicaAbysm extends AbstractAbysm {
    public ErroLogicaAbysm() {
        super();
    }

    @Override AbysmType type() {
        return AbysmType.ERRO_LOGICA;
    }

    @Override
    public String name() {
        return "Erro Lógica";
    }
}
