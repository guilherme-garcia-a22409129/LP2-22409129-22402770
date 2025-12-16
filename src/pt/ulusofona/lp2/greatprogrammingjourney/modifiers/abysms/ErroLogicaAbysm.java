package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.AbstractTool;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.ToolType;

import java.util.HashMap;

public class ErroLogicaAbysm extends AbstractAbysm {
    public ErroLogicaAbysm() {
        super();
    }

    @Override
    public AbysmType type() {
        return AbysmType.ERRO_LOGICA;
    }

    @Override
    public String code() {
        return "A:1";
    }

    @Override
    public String name() {
        return "Erro de lógica";
    }

    @Override
    public String message(String[] params) {
        return "Erro de lógica aplicado. Recua " + params[0] + "casas";
    }

    @Override
    public AbstractTool counter(HashMap<ToolType, AbstractTool> tools) {
        if (tools.containsKey(ToolType.TESTES_UNITARIOS)) {
            return tools.get(ToolType.TESTES_UNITARIOS);
        }

        return null;
    }
}
