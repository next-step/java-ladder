package nextstep.ladder.domain;

public class MountingBlock {

    private Boolean mountingBlock;

    private MountingBlock(Boolean mountingBlock) {
        this.mountingBlock = mountingBlock;
    }

    public Boolean getMountingBlock() {
        return mountingBlock;
    }

    public static MountingBlock of(Boolean beforeMountingBlock, MountingBlockGenerator mountingBlockGenerator) {

        if (beforeMountingBlock.equals(Boolean.TRUE)) {
            return new MountingBlock(Boolean.FALSE);
        }

        Boolean generatedMountBlock = mountingBlockGenerator.generateMountingBlock();
        return new MountingBlock(generatedMountBlock);
    }
}
