package nextstep.step2.service;

import nextstep.step2.VO.Line;

public class LineGenerator {

    public static Line createLine(int ladderWidth) {
        Line line = new Line();

        line.addPoint(PointGenerator.getFirstPoint());

        for (int i = 1; i < ladderWidth-1; i++) {
            line.addPoint(PointGenerator.getNextPoint(line.getLastPoint()));
        }

        line.addPoint(PointGenerator.getLastPoint(ladderWidth));

        return line;
    }
}
