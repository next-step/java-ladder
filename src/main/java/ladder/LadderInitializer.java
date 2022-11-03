package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.Ladder;
import ladder.domain.Rewards;
import ladder.domain.line.Line;
import ladder.domain.line.RandomLineGenerator;

public class LadderInitializer {

    public LadderGameData init(LadderInitDto initDto) {
        List<String> names = initDto.getNames();
        return new LadderGameData(
                initLadder(names, initDto.getHeight()),
                new Rewards(initDto.getRewardValues(), names.size()));
    }

    private Ladder initLadder(List<String> names, int height) {
        Ladder ladder = new Ladder(names, height);
        addLadder(ladder, names.size(), height);
        return ladder;
    }

    private void addLadder(Ladder ladder, int countOfPerson, int height) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> RandomLineGenerator.getLine(countOfPerson))
                .collect(Collectors.toUnmodifiableList());
        ladder.addLines(lines);
    }

}
