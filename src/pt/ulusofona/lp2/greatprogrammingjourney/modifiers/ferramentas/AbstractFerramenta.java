package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.ferramentas;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.Modifier;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.ModifierType;

public abstract class AbstractFerramenta implements Modifier {
    @Override
    public ModifierType type() {
        return ModifierType.TOOL;
    }
}
