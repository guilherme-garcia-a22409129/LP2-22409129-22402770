package pt.ulusofona.lp2.greatprogrammingjourney.modifiers.abysms;

import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.AbstractTool;
import pt.ulusofona.lp2.greatprogrammingjourney.modifiers.tools.ToolType;

import java.util.HashMap;

public class SegmentationFaultAbysm extends AbstractAbysm {
    public SegmentationFaultAbysm() {
        super();
    }

    @Override
    public AbysmType type() {
        return AbysmType.SEGMENTATION_FAULT;
    }

    @Override
    public String code() {
        return "A:9";
    }

    @Override
    public String name() {
        return "Segmentation Fault";
    }

    @Override
    public String message() {
        return "Segmentation Fault: Todos na casa recuam 3 casas";
    }

    @Override
    public AbstractTool counter(HashMap<ToolType, AbstractTool> tools) {
        //if (tools.containsKey(ToolType.IDE)) {
        //    return tools.get(ToolType.IDE);
        //}

        return null;
    }
}