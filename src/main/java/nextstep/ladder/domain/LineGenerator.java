package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LineGenerator {

    private MountingBlockGenerator mountingBlockGenerator;

    public LineGenerator(MountingBlockGenerator mountingBlockGenerator) {
        this.mountingBlockGenerator = mountingBlockGenerator;
    }

    public Line generateLine(int countOfPerson) {
        List<MountingBlock> mountingBlocks = new ArrayList<>();

        addToMountingBlocks(mountingBlocks, false);
        addToMountingBlocks(mountingBlocks, mountingBlockGenerator.generateMountingBlock());
        IntStream.range(1, getCountOfLine(countOfPerson)).forEach(i -> makeLine(mountingBlocks, i));
        addToMountingBlocks(mountingBlocks, false);

        return Line.of(mountingBlocks);
    }

    private void makeLine(List<MountingBlock> mountingBlocks, int mountingBlockIndex) {
        int beforeMountingBlockIndex = getPreviousMountingBlockIndex(mountingBlockIndex);
        MountingBlock beforeMountingBlock = mountingBlocks.get(beforeMountingBlockIndex);

        if (beforeMountingBlock.getMountingBlock()) {
            addToMountingBlocks(mountingBlocks, false);

            return;
        }

        addToMountingBlocks(mountingBlocks, mountingBlockGenerator.generateMountingBlock());
    }

    private void addToMountingBlocks(List<MountingBlock> mountingBlocks, boolean result) {
        mountingBlocks.add(MountingBlock.of(result));
    }

    private int getPreviousMountingBlockIndex(int mountingBlockIndex) {
        return mountingBlockIndex - 1;
    }

    private int getCountOfLine(int countOfPerson) {
        return countOfPerson - 1;
    }
}
