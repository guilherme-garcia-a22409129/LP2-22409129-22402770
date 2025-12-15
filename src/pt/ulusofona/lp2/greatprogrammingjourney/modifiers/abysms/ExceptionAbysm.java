package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

public class ExceptionAbysm extends AbstractAbysm {
    public ExceptionAbysm() {
        super();
    }

    @Override AbysmType type() {
        return AbysmType.EXCEPTION;
    }

    @Override
    public String name() {
        return "Exception";
    }
}
