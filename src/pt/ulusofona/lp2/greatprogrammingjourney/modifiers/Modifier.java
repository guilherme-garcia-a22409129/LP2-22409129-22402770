package pt.ulusofona.lp2.greatprogrammingjourney.modifiers;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abismos.*;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.ferramentas.*;

public interface Modifier {
    ModifierType type();
    String name();

    static Modifier valida(String[] info, int worldSize) {
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
                case 0 -> new ErroSintaxeAbismo();
                case 1 -> new ErroLogicaAbismo();
                case 2 -> new ExceptionAbismo();
                case 3 -> new FileNotFoundExceptionAbismo();
                case 4 -> new CrashAbismo();
                case 5 -> new CodigoDuplicadoAbismo();
                case 6 -> new EfeitosSecundariosAbismo();
                case 7 -> new BlueScreenOfDeathAbismo();
                case 8 -> new CicloInfinitoAbismo();
                case 9 -> new SegmentationFaultAbismo();
                default -> null;
            };
            case 1 -> switch (mod) {
                case 0 -> new HerancaFerramenta();
                case 1 -> new ProgramacaoFuncionalFerramenta();
                case 2 -> new TestesUnitariosFerramenta();
                case 3 -> new TratamentoExcepcoesFerramenta();
                case 4 -> new IDEFerramenta();
                case 5 -> new AjudaProfessorFerramenta();
                default -> null;
            };
            default -> null;
        };
    }
}