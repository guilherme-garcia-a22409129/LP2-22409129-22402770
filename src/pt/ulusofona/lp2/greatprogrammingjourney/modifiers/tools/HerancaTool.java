package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools;

public class HerancaTool extends AbstractTool {
    public HerancaTool() {
        super();
    }

    @Override ToolType type() {
        return ToolType.HERANCA;
    }

    @Override
    public String name() {
        return "Herança";
    }
}
