package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools;

public class AjudaProfessorTool extends AbstractTool {
    public AjudaProfessorTool() {
        super();
    }

    @Override
    public ToolType type() {
        return ToolType.AJUDA_DO_PROFESSOR;
    }

    @Override
    public String code() {
        return "T:5";
    }

    @Override
    public String name() {
        return "Ajuda Do Professor";
    }
}
