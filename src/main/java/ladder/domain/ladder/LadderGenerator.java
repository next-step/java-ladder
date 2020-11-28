package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.line.Line;
import ladder.domain.line.LineGenerator;
import ladder.domain.model.LadderGameInfo;

public class LadderGenerator {
    private final LineGenerator lineGenerator;

    public LadderGenerator() {
        this.lineGenerator = new LineGenerator();
    }

    //for Test
    public LadderGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Ladder generateLadder(LadderGameInfo ladderGameInfo) {
        List<Line> lines = ladderGameInfo.getLadderHeight().getLadderRange()
            .mapToObj(index -> lineGenerator.generateLine(ladderGameInfo.getUsers()))
            .collect(Collectors.toList());
        return new Ladder(lines);
    }
}
