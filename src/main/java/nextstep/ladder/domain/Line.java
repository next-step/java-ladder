package nextstep.ladder.domain;

import nextstep.ladder.view.LadderGameView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final Integer FIRST_MOUNTING_BLOCK = 0;

    private List<Boolean> mountingBlock;
    private MountingBlockGenerator mountingBlockGenerator;

    public Line(Integer countOfPerson, MountingBlockGenerator mountingBlockGenerator) {
        this.mountingBlock = new ArrayList<>();
        this.mountingBlockGenerator = mountingBlockGenerator;

        IntStream.rangeClosed(FIRST_MOUNTING_BLOCK, getTotalMountingBlock(countOfPerson))
                .forEach(this::makeLadderEachLine);
    }

    private Integer getTotalMountingBlock(Integer countOfPerson) {
        return countOfPerson - 2;
    }

    private void makeLadderEachLine(Integer mountingBlockIndex) {
        if (hasNotPreviousMountingBlock(mountingBlockIndex)) {
            Boolean generatedMountingBlock = this.mountingBlockGenerator.generateMountingBlock();
            this.mountingBlock.add(generatedMountingBlock);
            return;
        }

        this.mountingBlock.add(Boolean.FALSE);
    }

    private Boolean hasNotPreviousMountingBlock(Integer mountingBlockIndex) {

        if (mountingBlockIndex.equals(FIRST_MOUNTING_BLOCK)) {
            return Boolean.TRUE;
        }

        Boolean mountingBlockInPreviousLadderPoint = this.mountingBlock.get(getPreviousMountingBlockIndex(mountingBlockIndex));
        if (mountingBlockInPreviousLadderPoint.equals(Boolean.TRUE)) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    private Integer getPreviousMountingBlockIndex(Integer mountingBlockIndex) {
        return mountingBlockIndex - 1;
    }

    public void viewLine() {
        LadderGameView.viewLine(this.mountingBlock);
    }
}
