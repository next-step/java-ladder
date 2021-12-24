package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.engine.FirstClassList;
import nextstep.ladder.engine.Prize;
import nextstep.ladder.engine.Prizes;

public class LadderPrizes extends FirstClassList<Prize> implements Prizes {
    private LadderPrizes(final List<Prize> prizes) {
        super(prizes);
    }

    public static LadderPrizes fromString(final List<String> results) {
        if (results == null) {
            throw new IllegalArgumentException("invalid results: cannot be null or empty");
        }

        RailCount.validate(results.size());

        return new LadderPrizes(results.stream()
                .map(LadderPrize::of)
                .collect(Collectors.toList()));
    }

    public LadderPrizes mapByIndex(List<Integer> indexes) {
        return new LadderPrizes(indexes.stream()
                .map(this::elementOf)
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "Results {" +
                super.toString() +
                '}';
    }
}
