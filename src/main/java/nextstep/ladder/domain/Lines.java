package nextstep.ladder.domain;

import nextstep.ladder.constant.LadderConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {

    private List<Line> lines;
    private LineGenerator lineGenerator;

    private Lines(LineGenerator lineGenerator) {
        this.lines = new ArrayList<>();
        this.lineGenerator = lineGenerator;
    }

    public static Lines of(int countOfPerson, int ladderHeight) {
        Lines lines = new Lines(LadderGameManager.lineGenerator());
        IntStream.range(LadderConstants.FIRST_MOUNTING_BLOCK_INDEX, ladderHeight).forEach(i -> lines.initializeLadderLine(countOfPerson));

        return lines;
    }

    private void initializeLadderLine(int countOfPerson) {
        Line line = this.lineGenerator.generateLine(countOfPerson);
        this.lines.add(line);
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
