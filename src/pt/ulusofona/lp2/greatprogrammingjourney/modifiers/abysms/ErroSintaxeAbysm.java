package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

public class ErroSintaxeAbysm extends AbstractAbysm {
    public ErroSintaxeAbysm() {
        super();
    }

    @Override AbysmType type() {
        return AbysmType.ERRO_SINTAXE;
    }

    @Override
    public String name() {
        return "Erro Sintaxe";
    }
}
