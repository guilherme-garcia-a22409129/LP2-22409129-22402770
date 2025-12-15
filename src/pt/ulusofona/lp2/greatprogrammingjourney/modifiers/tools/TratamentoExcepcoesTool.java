package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools;

public class TratamentoExcepcoesTool extends AbstractTool {
    public TratamentoExcepcoesTool() {
        super();
    }

    @Override
    public ToolType type() {
        return ToolType.TRATAMENTOS_DE_EXCECOES;
    }

    @Override
    public String code() {
        return "T:3";
    }

    @Override
    public String name() {
        return "Tratamento de Excepções";
    }
}
