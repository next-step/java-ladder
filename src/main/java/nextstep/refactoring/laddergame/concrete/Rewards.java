package nextstep.refactoring.laddergame.concrete;

import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.Position;
import nextstep.refactoring.laddergame.engine.reward.Reward;
import nextstep.refactoring.laddergame.engine.LadderCompatibleList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Rewards implements LadderCompatibleList<Reward> {

    private final List<Reward> rewardList;

    public Rewards(List<Reward> rewardList) {
        this.rewardList = rewardList;
    }

    public static Rewards of(String... rewardStrings) {
        return Rewards.of(Arrays.asList(rewardStrings));
    }

    public static Rewards of(List<String> rewardStrings) {
        return IntStream.range(0, rewardStrings.size())
                        .mapToObj(i -> Reward.of(rewardStrings.get(i), Position.of(i)))
                        .collect(collectingAndThen(toList(), Rewards::new));
    }

    @Override
    public Reward get(Position position) {
        return rewardList.get(position.getIndex());
    }

    @Override
    public Stream<Reward> stream() {
        return rewardList.stream();
    }

    @Override
    public boolean isNotCompatible(Ladder ladder) {
        return rewardList.size() != ladder.numberOfPositions();
    }
}
