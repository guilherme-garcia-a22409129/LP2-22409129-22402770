package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.AbstractTool;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.ToolType;

import java.util.HashMap;

public class CodigoDuplicadoAbysm extends AbstractAbysm {
    public CodigoDuplicadoAbysm() {
        super();
    }

    @Override
    public AbysmType type() {
        return AbysmType.CODIGO_DUPLICADO;
    }

    @Override
    public String code() {
        return "A:5";
    }

    @Override
    public String name() {
        return "Código Duplicado";
    }

    @Override
    public String message(String[] params) {
        return "Código duplicado: Volta à posição anterior";
    }

    @Override
    public AbstractTool counter(HashMap<ToolType, AbstractTool> tools) {
        /*if (tools.containsKey(ToolType.IDE)) {
            return tools.get(ToolType.IDE);
        }*/

        return null;
    }
}
