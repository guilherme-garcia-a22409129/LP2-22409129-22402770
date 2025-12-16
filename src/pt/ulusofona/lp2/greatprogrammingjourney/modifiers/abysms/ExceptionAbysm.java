package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.AbstractTool;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.ToolType;

import java.util.HashMap;

public class ExceptionAbysm extends AbstractAbysm {
    public ExceptionAbysm() {
        super();
    }

    @Override
    public AbysmType type() {
        return AbysmType.EXCEPTION;
    }

    @Override
    public String code() {
        return "A:2";
    }

    @Override
    public String name() {
        return "Exception";
    }

    @Override
    public String message() {
        return "Exception! Recua 2 casas";
    }

    @Override
    public AbstractTool counter(HashMap<ToolType, AbstractTool> tools) {
        if (tools.containsKey(ToolType.TRATAMENTOS_DE_EXCECOES)) {
            return tools.get(ToolType.TRATAMENTOS_DE_EXCECOES);
        }

        return null;
    }
}
