package nextstep.ladder.domain;

import nextstep.ladder.view.LadderGameView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final Integer FIRST_MOUNTING_BLOCK_INDEX = 0;

    private List<MountingBlock> mountingBlocks;

    public Line(Integer countOfPerson) {
        this.mountingBlocks = new ArrayList<>();

        IntStream.rangeClosed(FIRST_MOUNTING_BLOCK_INDEX, getTotalMountingBlock(countOfPerson))
                .forEach(this::makeLine);
    }

    private Integer getTotalMountingBlock(Integer countOfPerson) {
        return countOfPerson - 2;
    }

    private void makeLine(Integer mountingBlockIndex) {

        MoutingBlockGenerator moutingBlockGenerator = new RandomMountingBlockGenerator();
        if (mountingBlockIndex.equals(FIRST_MOUNTING_BLOCK_INDEX)) {
            MountingBlock mountingBlock = MountingBlock.of(Boolean.FALSE, moutingBlockGenerator);
            this.mountingBlocks.add(mountingBlock);
            return;
        }

        Integer beforeMountingBlockIndex = getPreviousMountingBlockIndex(mountingBlockIndex);
        MountingBlock beforeMountingBlock = this.mountingBlocks.get(beforeMountingBlockIndex);

        this.mountingBlocks.add(MountingBlock.of(beforeMountingBlock.getMountingBlock(), moutingBlockGenerator));
    }

    private Integer getPreviousMountingBlockIndex(Integer mountingBlockIndex) {
        return mountingBlockIndex - 1;
    }

    public void viewLine() {
        LadderGameView.viewLine(this.mountingBlocks);
    }
}
