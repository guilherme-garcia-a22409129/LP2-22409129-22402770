package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

public class SegmentationFaultAbysm extends AbstractAbysm {
    public SegmentationFaultAbysm() {
        super();
    }

    @Override AbysmType type() {
        return AbysmType.SEGMENTATION_FAULT;
    }

    @Override
    public String name() {
        return "Segmentation Fault";
    }
}