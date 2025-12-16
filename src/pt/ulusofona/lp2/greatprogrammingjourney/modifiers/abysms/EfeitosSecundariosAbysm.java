package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.AbstractTool;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.ToolType;

import java.util.HashMap;

public class EfeitosSecundariosAbysm extends AbstractAbysm {
    public EfeitosSecundariosAbysm() {
        super();
    }

    @Override
    public AbysmType type() {
        return AbysmType.EFEITOS_SECUNDARIOS;
    }

    @Override
    public String code() {
        return "A:6";
    }

    @Override
    public String name() {
        return "Efeitos secundários: Volta à posição de 2 movimentos atrás";
    }

    @Override
    public String message() {
        return "";
    }

    @Override
    public AbstractTool counter(HashMap<ToolType, AbstractTool> tools) {
        if (tools.containsKey(ToolType.PROGRAMACAO_FUNCIONAL)) {
            return tools.get(ToolType.PROGRAMACAO_FUNCIONAL);
        }

        return null;
    }
}
