package nextstep.ladder.model;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.IntStream;

import nextstep.ladder.model.dto.LadderGameResult;

public class LadderGame {
    public static LadderGameResult play(People people, Ladder ladder, Rewards rewards) {
        List<Integer> resultPositions = IntStream.range(0, people.getPeopleCount())
            .map(ladder::move)
            .boxed()
            .collect(toList());

        return new LadderGameResult(people, rewards, resultPositions);
    }
}
