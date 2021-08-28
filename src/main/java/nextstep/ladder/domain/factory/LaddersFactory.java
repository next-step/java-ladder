package nextstep.ladder.domain.factory;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Ladders;
import nextstep.ladder.domain.point.strategy.ConnectedPointGenerateStrategy;
import nextstep.ladder.domain.point.strategy.RandomConnectedPointGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class LaddersFactory {

    public static Ladders generateWithRandomStrategy(int count, int height) {
        List<Ladder> ladders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Ladder ladder = new Ladder(height, new RandomConnectedPointGenerateStrategy(height));
            ladders.add(ladder);
        }

        return new Ladders(ladders, height);
    }
}
