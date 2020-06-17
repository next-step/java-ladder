package nextstep.ladder.domain;

import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderLinesTest {

    @DisplayName("첫번째 라인은 최대높이-1 만큼의 Point 무조건 생성하고, 두번째 라인은 첫번쨰 라인과 연결되는 포인트가 아닌 3번쨰 포인트연결을 생성한다.")
    @Test
    void createLadder() {
        //given
        Point maxPoint = Point.of(3);
        LadderLines ladderLines = new LadderLines();

        //when
        ladderLines.addLine(Order.of(1), () -> true, maxPoint);
        ladderLines.addLine(Order.of(2), () -> true, maxPoint);

        //then
        /*
        | ------ |        |
        | ------ |        |
        |        | ------ |
         */
        assertAll(
                () -> assertThat(ladderLines.hasConnection(1, 1)).isTrue(),
                () -> assertThat(ladderLines.hasConnection(1, 2)).isTrue(),
                () -> assertThat(ladderLines.hasConnection(1, 3)).isFalse(),
                () -> assertThat(ladderLines.hasConnection(2, 3)).isTrue()
        );
    }


}