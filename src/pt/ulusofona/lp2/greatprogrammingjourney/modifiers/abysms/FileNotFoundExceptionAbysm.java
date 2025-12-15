package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

public class FileNotFoundExceptionAbysm extends AbstractAbysm {
    public FileNotFoundExceptionAbysm() {
        super();
    }

    @Override AbysmType type() {
        return AbysmType.FILE_NOT_FOUND_EXCEPTION;
    }

    @Override
    public String name() {
        return "FileNotFoundException";
    }
}
