package ladder.domain.ladder;

import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.ladder.strategy.RandomStairGenerationStrategy;
import ladder.fixture.LadderFixtures;
import ladder.fixture.PlayerAndPrizeFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    private static LadderShapeInfo shapeInfoOfSinglePlayer;
    private static LadderShapeInfo shapeInfoOfMultiplePlayers;

    @BeforeEach
    void setUp() {
        shapeInfoOfSinglePlayer = LadderShapeInfo.valueOf(
                PlayerAndPrizeFixtures.of().getSinglePlayersAndPrizes(), Height.of(Height.MIN_HEIGHT));

        shapeInfoOfMultiplePlayers = LadderShapeInfo.valueOf(
                PlayerAndPrizeFixtures.of().getMultiplePlayersAndPrizes(), Height.of(Height.MIN_HEIGHT * 5));
    }

    @DisplayName("사다리 생성 실패: 사다리의 높이가 1보다 작은 경우")
    @Test
    void createFailureByHeightLessThanMin() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(
                        LadderShapeInfo.valueOf(
                                PlayerAndPrizeFixtures.of().getMultiplePlayersAndPrizes(),
                                Height.of(Height.MIN_HEIGHT - 1)),
                        new RandomStairGenerationStrategy()));
    }

    @DisplayName("사다리 생성 실패: PlayersAndPrizes 가 null 인 경우")
    @Test
    void createFailureByPlayersLessThanMin() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(
                        LadderShapeInfo.valueOf(null, Height.of(Height.MIN_HEIGHT)),
                        new RandomStairGenerationStrategy()));
    }

    @DisplayName("Ladder 생성")
    @Test
    void create() {
        assertThatCode(() -> Ladder.of(shapeInfoOfMultiplePlayers, new RandomStairGenerationStrategy()))
                .doesNotThrowAnyException();
    }

    @DisplayName("한 명의 사용자가 사다리를 타면 index 0 의 prize 리스트를 반환")
    @Test
    void rideWithSinglePlayer() {
        Ladder ladder = Ladder.of(shapeInfoOfSinglePlayer, new RandomStairGenerationStrategy());

        Positions positions = ladder.ride();

        assertThat(positions.indexOf(Position.of(Position.MIN_POSITION)))
                .isEqualTo(Position.of(Position.MIN_POSITION));
    }

    @DisplayName("모든 사용자가 사다리를 타고 난 결과에 대한 prize position 리스트를 반환")
    @Test
    void playWithMultiplePlayers() {
        Ladder ladder = Ladder.of(LadderFixtures.of().getLadderShapeInfo(),
                new LadderFixtures.TestStairGenerationStrategy());
        Positions positions = ladder.ride();

        List<Integer> expectedPrizePositions = Arrays.asList(1, 0, 4, 3, 2);

        IntStream.range(0, positions.size())
                .forEach(index ->
                        assertThat(positions.indexOf(Position.of(index)).getPosition())
                                .isEqualTo(expectedPrizePositions.get(index))
                );
    }
}
