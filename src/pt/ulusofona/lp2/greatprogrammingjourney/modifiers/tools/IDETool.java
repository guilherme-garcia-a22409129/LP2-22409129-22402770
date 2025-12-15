package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools;

public class IDETool extends AbstractTool {
    public IDETool() {
        super();
    }

    @Override
    public ToolType type() {
        return ToolType.IDE;
    }

    @Override
    public String code() {
        return "T:4";
    }

    @Override
    public String name() {
        return "IDE";
    }
}
