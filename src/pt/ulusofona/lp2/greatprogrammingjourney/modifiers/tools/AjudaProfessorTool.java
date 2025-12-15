package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools;

public class AjudaProfessorTool extends AbstractTool {
    public AjudaProfessorTool() {
        super();
    }

    @Override ToolType type() {
        return ToolType.AJUDA_DO_PROFESSOR;
    }

    @Override
    public String name() {
        return "Ajuda Do Professor";
    }
}
