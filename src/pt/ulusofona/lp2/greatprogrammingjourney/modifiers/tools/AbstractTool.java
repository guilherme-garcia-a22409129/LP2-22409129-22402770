package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.Modifier;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.ModifierGroup;

public abstract class AbstractTool implements Modifier {
    abstract public ToolType type();

    @Override
    public ModifierGroup group() {
        return ModifierGroup.TOOL;
    }
}
