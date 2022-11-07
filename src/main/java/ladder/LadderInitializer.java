package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.Ladder;
import ladder.domain.Rewards;
import ladder.domain.line.Line;
import ladder.domain.line.RandomLineFactory;

public class LadderInitializer {

    public LadderGameData init(LadderInitDto initDto) {
        List<String> names = initDto.getNames();
        return new LadderGameData(
                initLadder(names, initDto.getHeight()),
                new Rewards(initDto.getRewardValues(), names.size()));
    }

    private Ladder initLadder(List<String> names, int height) {
        return new Ladder(names, height, initLines(names.size(), height));
    }

    private List<Line> initLines(int countOfPerson, int height) {
        return IntStream.range(0, height)
                .mapToObj(i -> RandomLineFactory.getLine(countOfPerson))
                .collect(Collectors.toUnmodifiableList());
    }

}
