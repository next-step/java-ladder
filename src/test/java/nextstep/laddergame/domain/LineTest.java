package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    void create() {
        int people = 5;
        Line line = new Line(people*2);
        assertThat(line).isNotNull();
    }

    @Test
    @DisplayName(value = "지나갈 수 있는 길인지 아닌지 boolean을 리턴함.")
    void isWay() {
        Line line = new Line(10);
        assertThat(line.isWay(9)).isIn(true,false);
    }

    @Test
    @DisplayName(value = "사다리의 가로길이보다 큰 위치를 조회할 수 없음")
    void isWay_OverSize() {
        Line line = new Line(10);
        assertThatThrownBy(() -> line.isWay(10))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName(value = "짝수 위치는 항상 true")
    void isNotOddWay_ShouldReturnTrue() {
        Line line = new Line(10);
        assertThat(line.isWay(0)).isTrue();
        assertThat(line.isWay(2)).isTrue();
    }
}