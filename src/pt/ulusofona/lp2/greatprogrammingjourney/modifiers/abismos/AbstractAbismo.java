package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abismos;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.Modifier;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.ModifierType;

public abstract class AbstractAbismo implements Modifier {
    @Override
    public ModifierType type() {
        return ModifierType.ABYSM;
    }
}
