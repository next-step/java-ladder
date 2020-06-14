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
        return mountingBlocks;
    }
}
