package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools;

public class IDETool extends AbstractTool {
    public IDETool() {
        super();
    }

    @Override ToolType type() {
        return ToolType.IDE;
    }

    @Override
    public String name() {
        return "IDE";
    }
}
