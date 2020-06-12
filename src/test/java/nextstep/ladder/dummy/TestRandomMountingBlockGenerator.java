package nextstep.ladder.dummy;

import nextstep.ladder.domain.MountingBlockGenerator;

public class TestRandomMountingBlockGenerator implements MountingBlockGenerator {

    private Boolean generatedMountingBlock;

    public TestRandomMountingBlockGenerator(Boolean generatedMountingBlock) {
        this.generatedMountingBlock = generatedMountingBlock;
    }

    @Override
    public Boolean generateMountingBlock() {
        return this.generatedMountingBlock;
    }
}
