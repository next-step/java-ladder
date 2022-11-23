package game;

import game.domain.ladder.FixedNumberOneAndTrueValueStrategy;
import game.domain.ladder.FixedNumberZeroAndFalseValueStrategy;
import game.domain.ladder.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {

    private Line lineWithTwoPeople;
    private Line lineWithThreePeople;

    @BeforeEach
    public void init() {
        lineWithTwoPeople = Line.of(2, new FixedNumberOneAndTrueValueStrategy());
        lineWithThreePeople = Line.of(3, new FixedNumberZeroAndFalseValueStrategy());
    }

    @Test
    public void 사다리_가로줄_생성() {
        assertAll(
                () -> assertThat(lineWithTwoPeople.points()).hasSize(2),
                () -> assertThat(lineWithThreePeople.points()).hasSize(3)
        );
    }

    @Test
    public void 사다리_포인트_왼쪽_이동() {
        assertThat(lineWithTwoPeople.movePoint(1)).isEqualTo(0);
    }

    @Test
    public void 사다리_포인트_오른쪽_이동() {
        assertThat(lineWithTwoPeople.movePoint(0)).isEqualTo(1);
    }
}
