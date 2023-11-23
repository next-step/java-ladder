package ladder;

import ladder.domain.Ladder;
import ladder.domain.Position;
import ladder.factory.RandomRowStrategy;
import ladder.fixture.FixedRowStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.fixture.LadderFixture.ladderRowFixture;
import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {

    @Test
    @DisplayName("사다리 높이만큼 다리를 놓을 수 있다")
    public void ladder_height() {
        assertThat(new Ladder(new RandomRowStrategy(5, 4)))
            .extracting(Ladder::rows)
            .asList()
            .hasSize(5);
    }

    @Test
    @DisplayName("사다리의 시작 위치에서 도달하는 위치를 구할 수 있다")
    public void position_to_position() {
        Ladder ladder = new Ladder(new FixedRowStrategy(ladderRowFixture()));
        assertThat(ladder.positionFrom(new Position(1))).isEqualTo(new Position(3));
    }

}
