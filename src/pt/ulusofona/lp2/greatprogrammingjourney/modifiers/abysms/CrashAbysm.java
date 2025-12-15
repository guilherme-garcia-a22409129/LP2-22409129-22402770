package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

public class CrashAbysm extends AbstractAbysm {
    public CrashAbysm() {
        super();
    }

    @Override AbysmType type() {
        return AbysmType.CRASH;
    }

    @Override
    public String name() {
        return "Crash";
    }
}
