package ladder.domain.ladder;

import ladder.domain.ladder.shape.PillarCount;
import ladder.domain.ladder.strategy.RandomStairGenerationStrategy;
import ladder.fixture.LadderFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class RowPillarsTest {

    private int width = PillarCount.MIN_COUNT * 5;
    private PillarCount pillarCount;

    @BeforeEach
    void setUp() {
        pillarCount = PillarCount.of(width);
    }

    @DisplayName("기둥의 최소 개수인 1보다 작은 수로 기둥을 만들 수 없음")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RowPillars.of(
                        PillarCount.of(PillarCount.MIN_COUNT - 1), new RandomStairGenerationStrategy()));
    }

    @DisplayName("Pillar 생성")
    @Test
    void create() {
        assertThatCode(() -> RowPillars.of(pillarCount, new RandomStairGenerationStrategy()))
                .doesNotThrowAnyException();
    }

    @DisplayName("RowPillars 의 모든 계단을 반환")
    @Test
    void getStairs() {
        RowPillars rowPillars = RowPillars.of(pillarCount, new RandomStairGenerationStrategy());

        assertThat(rowPillars.getStairs().size())
                .isEqualTo(width);
    }

    @DisplayName("RowPillars 의 기둥의 개수 반환")
    @Test
    void getWidth() {
        assertThat(RowPillars.of(pillarCount, new RandomStairGenerationStrategy()).getWidth())
                .isEqualTo(width);
    }

    @DisplayName("position 위치의 계단 상태에 따라 다음 위치를 반환")
    @Test
    void move() {
        RowPillars rowPillars = RowPillars.of(
                pillarCount, new LadderFixtures.TestStairGenerationStrategy());
        List<Stair> stairs = rowPillars.getStairs();

        IntStream.range(0, width)
                .forEach(index -> {
                    Position position = Position.of(index);

                    assertThat(stairs.get(index).move(position))
                            .isEqualTo(LadderFixtures.of().getExpectedPositions().get(index));
                });
    }
}
