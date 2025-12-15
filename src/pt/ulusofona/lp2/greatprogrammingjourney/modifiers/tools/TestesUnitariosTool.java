package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools;

public class TestesUnitariosTool extends AbstractTool {
    public TestesUnitariosTool() {
        super();
    }

    @Override
    public ToolType type() {
        return ToolType.TESTES_UNITARIOS;
    }

    @Override
    public String code() {
        return "T:2";
    }

    @Override
    public String name() {
        return "Testes Unitários";
    }
}
