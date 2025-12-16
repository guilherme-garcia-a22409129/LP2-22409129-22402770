package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.AbstractTool;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.ToolType;

import java.util.HashMap;

public class BlueScreenOfDeathAbysm extends AbstractAbysm {
    public BlueScreenOfDeathAbysm() {
        super();
    }

    @Override
    public AbysmType type() {
        return AbysmType.BLUE_SCREEN_OF_DEATH;
    }

    @Override
    public String code() {
        return "A:7";
    }

    @Override
    public String name() {
        return "Blue Screen of Death";
    }

    @Override
    public String message(String[] params) {
        return "Blue Screen of Death: Perde o jogo";
    }

    @Override
    public AbstractTool counter(HashMap<ToolType, AbstractTool> tools) {
        if (tools.containsKey(ToolType.TRATAMENTOS_DE_EXCECOES)) {
            return tools.get(ToolType.TRATAMENTOS_DE_EXCECOES);
        }

        return null;
    }
}
