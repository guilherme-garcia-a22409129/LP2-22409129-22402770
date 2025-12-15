package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools;

public class ProgramacaoFuncionalTool extends AbstractTool {
    public ProgramacaoFuncionalTool() {
        super();
    }

    @Override ToolType type() {
        return ToolType.PROGRAMACAO_FUNCIONAL;
    }

    @Override
    public String name() {
        return "Programação Funcional";
    }
}
