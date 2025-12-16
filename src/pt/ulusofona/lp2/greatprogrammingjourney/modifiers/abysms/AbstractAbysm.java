package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.Modifier;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.ModifierGroup;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.AbstractTool;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.ToolType;

import java.util.HashMap;

public abstract class AbstractAbysm implements Modifier {
    abstract public AbysmType type();
    abstract public String message(String[] params);
    abstract public AbstractTool counter(HashMap<ToolType, AbstractTool> tools);

    @Override
    public ModifierGroup group() {
        return ModifierGroup.ABYSM;
    }
}
