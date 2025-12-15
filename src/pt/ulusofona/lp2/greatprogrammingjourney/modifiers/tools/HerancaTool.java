package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools;

public class HerancaTool extends AbstractTool {
    public HerancaTool() {
        super();
    }

    @Override
    public ToolType type() {
        return ToolType.HERANCA;
    }

    @Override
    public String code() {
        return "T:0";
    }

    @Override
    public String name() {
        return "Herança";
    }
}
