package ladder.controller.dto;

import java.util.List;

public class LadderLine {

    private final List<Boolean> pointList;

    public LadderLine(List<Boolean> pointList) {
        this.pointList = pointList;
    }

    public List<Boolean> getPointList() {
        return pointList;
    }
}
