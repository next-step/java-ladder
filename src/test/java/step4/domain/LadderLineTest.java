package step4.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import step4.strategy.RandomPointCreateStrategy;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderLineTest {

    @RepeatedTest(10)
    void 랜덤_생성_전략으로_사다리_라인을_생성한다() {
        //given
        LadderLine ladderLine = LadderLine.of(Width.of(4), new RandomPointCreateStrategy());
        //when
        for (Point point : ladderLine.points()) {
            System.out.println(point.toString());
        }
        //then
        assertThat(ladderLine.size()).isEqualTo(4);
    }

    @Test
    void 사다리_라인을_생성한다() {
        //given
        LadderLine ladderLine = LadderLine.of(Width.of(1),
                width -> Arrays.asList(Point.of(Position.of(0), Direction.of(false, true))));
        //when
        //then
        assertThat(ladderLine.size()).isEqualTo(1);
    }

    @Test
    void 사다리_라인이_겹치면_IllegalArgumentException_이_발생한다() {
        //given
        //when
        //then
        assertThatThrownBy(() ->
            LadderLine.of(Width.of(1), width -> Arrays.asList(Point.of(Position.of(0), Direction.of(true, true))))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 라인을_이동한다() {
        //given
        LadderLine ladderLine = LadderLine.of(Width.of(4), new RandomPointCreateStrategy());
        //when
        Position movedPosition = ladderLine.move(Position.of(0));
        //then
        assertThat(movedPosition.position()).isGreaterThanOrEqualTo(0);
    }
}
