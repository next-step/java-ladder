package nextstep.ladder.domain;

import java.util.List;

public class Line {

    private List<MountingBlock> mountingBlocks;

    private Line(List<MountingBlock> mountingBlocks) {
        this.mountingBlocks = mountingBlocks;
    }

    public static Line of(List<MountingBlock> mountingBlocks) {
        return new Line(mountingBlocks);
    }

    public List<MountingBlock> getMountingBlocks() {
        return this.mountingBlocks;
    }

    public Point moveLeftOrRight(Point point) {

        XAxis xAxis = point.getxAxis();
        int xValue = xAxis.getxAxis();

        if (this.mountingBlocks.get(xValue).getMountingBlock()) {
            return point.moveToRight();
        }

        if (this.mountingBlocks.get(xValue - 1).getMountingBlock()) {
            return point.moveToLeft();
        }

        return point;
    }
}
