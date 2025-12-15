package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.AbstractTool;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.ToolType;

import java.util.HashMap;

public class CrashAbysm extends AbstractAbysm {
    public CrashAbysm() {
        super();
    }

    @Override
    public AbysmType type() {
        return AbysmType.CRASH;
    }

    @Override
    public String code() {
        return "A:4";
    }

    @Override
    public String name() {
        return "Crash";
    }

    @Override
    public String message() {
        return "";
    }

    @Override
    public AbstractTool counter(HashMap<ToolType, AbstractTool> tools) {
        if (tools.containsKey(ToolType.IDE)) {
            return tools.get(ToolType.IDE);
        }

        return null;
    }
}
