package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools;

public class ProgramacaoFuncionalTool extends AbstractTool {
    public ProgramacaoFuncionalTool() {
        super();
    }

    @Override
    public ToolType type() {
        return ToolType.PROGRAMACAO_FUNCIONAL;
    }

    @Override
    public String code() {
        return "T:1";
    }

    @Override
    public String name() {
        return "Programação Funcional";
    }
}
