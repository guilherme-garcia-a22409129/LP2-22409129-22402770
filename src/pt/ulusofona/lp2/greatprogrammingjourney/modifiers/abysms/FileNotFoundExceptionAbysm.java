package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.AbstractTool;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.ToolType;

import java.util.HashMap;

public class FileNotFoundExceptionAbysm extends AbstractAbysm {
    public FileNotFoundExceptionAbysm() {
        super();
    }

    @Override
    public AbysmType type() {
        return AbysmType.FILE_NOT_FOUND_EXCEPTION;
    }

    @Override
    public String code() {
        return "A:3";
    }

    @Override
    public String name() {
        return "FileNotFoundException";
    }

    @Override
    public String message() {
        return "";
    }

    @Override
    public AbstractTool counter(HashMap<ToolType, AbstractTool> tools) {
        if (tools.containsKey(ToolType.TRATAMENTOS_DE_EXCECOES)) {
            return tools.get(ToolType.TRATAMENTOS_DE_EXCECOES);
        }

        if (tools.containsKey(ToolType.IDE)) {
            return tools.get(ToolType.IDE);
        }

        return null;
    }
}
