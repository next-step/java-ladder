package nextstep.ladder.dummy;

import nextstep.ladder.domain.MountingBlockGenerator;

import java.util.Queue;

public class TestQueueMountingBlockGenerator implements MountingBlockGenerator {

    private Queue<Boolean> expectedMountingBlocks;

    public TestQueueMountingBlockGenerator(Queue<Boolean> expectedMountingBlocks) {
        this.expectedMountingBlocks = expectedMountingBlocks;
    }

    @Override
    public Boolean generateMountingBlock() {
        return this.expectedMountingBlocks.poll();
    }
}
