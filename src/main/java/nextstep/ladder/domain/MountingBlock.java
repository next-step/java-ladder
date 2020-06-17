package nextstep.ladder.domain;

public class MountingBlock {

    private boolean mountingBlock;

    private MountingBlock(boolean mountingBlock) {
        this.mountingBlock = mountingBlock;
    }

    public boolean getMountingBlock() {
        return mountingBlock;
    }

    public static MountingBlock of(boolean mountingBlock) {
        return new MountingBlock(mountingBlock);
    }
}
