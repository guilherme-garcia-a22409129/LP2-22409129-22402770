package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.AbstractTool;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.ToolType;

import java.util.HashMap;

public class CicloInfinitoAbysm extends AbstractAbysm {
    public CicloInfinitoAbysm() {
        super();
    }

    @Override
    public AbysmType type() {
        return AbysmType.CICLO_INFINITO;
    }

    @Override
    public String code() {
        return "A:8";
    }

    @Override
    public String name() {
        return "Ciclo Infinito";
    }

    @Override
    public String message() {
        return "Ciclo infinito: Fica preso na casa";
    }

    @Override
    public AbstractTool counter(HashMap<ToolType, AbstractTool> tools) {
        if (tools.containsKey(ToolType.IDE)) {
            return tools.get(ToolType.IDE);
        }

        return null;
    }
}
