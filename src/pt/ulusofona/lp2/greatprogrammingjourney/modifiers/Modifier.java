package pt.ulusofona.lp2.greatprogrammingjourney.modifiers;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms.*;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.*;

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
                case 2 -> new TestesUnitariosTool();
                case 3 -> new TratamentoExcepcoesTool();
                case 4 -> new IDETool();
                case 5 -> new AjudaProfessorTool();
                default -> null;
            };
            default -> null;
        };
    }
}