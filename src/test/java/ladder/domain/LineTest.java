package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LineTest {

    @Test
    @DisplayName("라인 생성시 사람수가 2보다 작으면 IllegalArgumentException이 발생한다.")
    void personCountException() {
        int personCount = 1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(personCount, () -> true))
                .withMessage("사다리 게임에 참여하는 사람 수가 너무 작습니다. 사람 수 : " + personCount);
    }

    @Test
    @DisplayName("라인의 왼쪽 포지션에서 move 함수 호출하면 포지션 +1을 리턴한다.")
    void moveRight(){
        Line line = new Line(2, () -> true);
        int startPosition = 0;
        int endPosition = line.move(startPosition);
        assertEquals(endPosition, startPosition + 1);
    }

    @Test
    @DisplayName("라인의 오른쪽 포지션에서 move 함수 호출하면 포지션 -1을 리턴한다.")
    void moveLeft(){
        Line line = new Line(2, () -> true);
        int startPosition = 1;
        int endPosition = line.move(startPosition);
        assertEquals(endPosition, startPosition - 1);
    }

}