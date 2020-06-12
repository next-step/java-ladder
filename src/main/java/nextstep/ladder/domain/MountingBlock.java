package nextstep.ladder.domain;

public class MountingBlock {

    private Boolean mountingBlock;
    private MountingBlockGenerator mountingBlockGenerator;

    private MountingBlock(Boolean mountingBlock, MountingBlockGenerator mountingBlockGenerator) {
        this.mountingBlock = mountingBlock;
        this.mountingBlockGenerator = mountingBlockGenerator;
    }

    public Boolean getMountingBlock() {
        return mountingBlock;
    }

    public static MountingBlock of(Boolean beforeMountingBlock, MountingBlockGenerator mountingBlockGenerator) {

        if (beforeMountingBlock.equals(Boolean.TRUE)) {
            return new MountingBlock(Boolean.FALSE, mountingBlockGenerator);
        }

        Boolean generatedMountBlock = mountingBlockGenerator.generateMountingBlock();
        return new MountingBlock(generatedMountBlock, mountingBlockGenerator);
    }
}
