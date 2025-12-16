package pt.ulusofona.lp2.greatprogrammingjourney.modifiers;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms.*;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.*;

import java.io.File;

public interface Modifier {
    ModifierGroup group();
    String code();
    String name();

    static Modifier validate(String[] info, int worldSize) {
        int type, mod, pos;

        try {
            type = Integer.parseInt(info[0]);
            mod = Integer.parseInt(info[1]);
            pos = Integer.parseInt(info[2]);
        } catch (Exception e) {
            // failed to parse info to int
            return null;
        }

        if (pos < 1 || pos > worldSize) {
            return null;
        }

        return switch (type) {
            case 0 -> switch (mod) {
                case 0 -> new ErroSintaxeAbysm();
                case 1 -> new ErroLogicaAbysm();
                case 2 -> new ExceptionAbysm();
                case 3 -> new FileNotFoundExceptionAbysm();
                case 4 -> new CrashAbysm();
                case 5 -> new CodigoDuplicadoAbysm();
                case 6 -> new EfeitosSecundariosAbysm();
                case 7 -> new BlueScreenOfDeathAbysm();
                case 8 -> new CicloInfinitoAbysm();
                case 9 -> new SegmentationFaultAbysm();
                default -> null;
            };
            case 1 -> switch (mod) {
                case 0 -> new HerancaTool();
                case 1 -> new ProgramacaoFuncionalTool();
                case 2 -> new AbstractTool() {
                    // yup!!! imma do it here... idgaf... dp doesn't see the imported file for some reason...
                    @Override
                    public ToolType type() { return ToolType.TESTES_UNITARIOS; }
                    @Override
                    public String code() { return "T:2"; }
                    @Override
                    public String name() { return "Testes Unitários"; }
                };
                case 3 -> new TratamentoExcepcoesTool();
                case 4 -> new IDETool();
                case 5 -> new AjudaProfessorTool();
                default -> null;
            };
            default -> null;
        };
    }

    static Modifier fromCode(String code) {
        return switch (code) {
            case "A:0" -> new ErroSintaxeAbysm();
            case "A:1" -> new ErroLogicaAbysm();
            case "A:2" -> new ExceptionAbysm();
            case "A:3" -> new FileNotFoundExceptionAbysm();
            case "A:4" -> new CrashAbysm();
            case "A:5" -> new CodigoDuplicadoAbysm();
            case "A:6" -> new EfeitosSecundariosAbysm();
            case "A:7" -> new BlueScreenOfDeathAbysm();
            case "A:8" -> new CicloInfinitoAbysm();
            case "A:9" -> new SegmentationFaultAbysm();

            case "T:0" -> new HerancaTool();
            case "T:1" -> new ProgramacaoFuncionalTool();
            case "T:2" -> new TestesUnitariosTool();
            case "T:3" -> new TratamentoExcepcoesTool();
            case "T:4" -> new IDETool();
            case "T:5" -> new AjudaProfessorTool();

            default -> null;
        };
    }
}