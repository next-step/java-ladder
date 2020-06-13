package ladder.fixture;

import ladder.domain.LadderGame;
import ladder.domain.ladder.Position;
import ladder.domain.ladder.StairState;
import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.ladder.strategy.StairGenerationStrategy;
import ladder.view.ResultView;

import java.util.*;

public class LadderFixtures {

    private final LadderShapeInfo ladderShapeInfo;
    private final LadderGame ladderGame;

    private final List<Position> expectedPositions = new ArrayList<>();
    private final List<StairState> expectedStates = new ArrayList<>();
    private final List<List<Boolean>> expectedLines = new ArrayList<>();

    private LadderFixtures() {
        Height height = Height.of(Height.MIN_HEIGHT * 5);

        ladderShapeInfo = LadderShapeInfo.valueOf(PlayerAndPrizeFixtures.of().getMultiplePlayersAndPrizes(), height);
        ladderGame = LadderGame.of(ladderShapeInfo, new TestStairGenerationStrategy());
        ResultView.printLadderShape(ladderGame.ready());

        initExpectedPositions();
        initExpectedStates();
        initExpectedLines();
    }

    public static LadderFixtures of() {
        return new LadderFixtures();
    }

    private void initExpectedPositions() {
        expectedPositions.addAll(
                Arrays.asList(Position.of(1), Position.of(0), Position.of(2),
                        Position.of(4), Position.of(3)));
    }

    private void initExpectedStates() {
        expectedStates.addAll(
                Arrays.asList(StairState.RIGHT, StairState.LEFT, StairState.EMPTY,
                        StairState.RIGHT, StairState.LEFT));
    }

    private void initExpectedLines() {
        expectedLines.add(Arrays.asList(true, false, false, true, false));
        expectedLines.add(Arrays.asList(false, false, true, false, false));
        expectedLines.add(Arrays.asList(false, false, false, true, false));
        expectedLines.add(Arrays.asList(false, true, false, false, false));
        expectedLines.add(Arrays.asList(false, true, false, false, false));
    }

    public LadderGame getLadderGame() {
        return ladderGame;
    }

    public LadderShapeInfo getLadderShapeInfo() {
        return ladderShapeInfo;
    }

    public List<Position> getExpectedPositions() {
        return expectedPositions;
    }

    public List<List<Boolean>> getExpectedLines() {
        return expectedLines;
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
}
