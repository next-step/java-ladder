package ladder.fixture;

import ladder.domain.LadderGame;
import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.ladder.strategy.StairGenerationStrategy;
import ladder.view.ResultView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LadderFixtures {

    public final LadderShapeInfo ladderShapeInfo;
    public final LadderGame ladderGame;

    private LadderFixtures() {
        Height height = Height.of(Height.MIN_HEIGHT * 5);

        ladderShapeInfo = LadderShapeInfo.valueOf(PlayerAndPrizeFixtures.of().getMultiplePlayersAndPrizes(), height);
        ladderGame = LadderGame.of(ladderShapeInfo, new TestStairGenerationStrategy());
        ResultView.printLadderShape(ladderGame.ready());
    }

    public static LadderFixtures of() {
        return new LadderFixtures();
    }

    public static class TestStairGenerationStrategy implements StairGenerationStrategy {
        private Queue<Boolean> stairQueue;

        public TestStairGenerationStrategy() {
            stairQueue = new LinkedList<>();

            stairQueue.addAll(Arrays.asList(true, false, true, false));
            stairQueue.addAll(Arrays.asList(false, true, false, false));
            stairQueue.addAll(Arrays.asList(false, true, false, true));
            stairQueue.addAll(Arrays.asList(false, false, true, false));
            stairQueue.addAll(Arrays.asList(true, false, false, true));
        }

        @Override
        public boolean generate() {
            return stairQueue.poll();
        }
    }

    public LadderGame getLadderGame() {
        return ladderGame;
    }
}
