package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImprovingPointTest {

    @DisplayName("첫번째 점일때 이동하는 경우와 이동하지 않는 경우 인덱스 확인한다.")
    @Test
    void first() {
        assertThat(ImprovingPoint.first(true).move()).isEqualTo(1);
        assertThat(ImprovingPoint.first(false).move()).isEqualTo(0);
    }

    @DisplayName("인덱스가 이동하지 않는 경우")
    @Test
    void nextStay() {
        ImprovingPoint second = ImprovingPoint.first(false).next(false);
        assertThat(second.move()).isEqualTo(1);
    }

    @DisplayName("인덱스가 왼쪽으로 이동하는 경우")
    @Test
    void nextLeft() {
        ImprovingPoint second = ImprovingPoint.first(true).next(false);
        assertThat(second.move()).isEqualTo(0);
    }

    @DisplayName("인덱스가 오른쪽으로 이동하는 경우")
    @Test
    void nextRight() {
        ImprovingPoint second = ImprovingPoint.first(false).next(true);
        assertThat(second.move()).isEqualTo(2);
    }

    @DisplayName("인덱스가 0으로 이동하는 경우")
    @Test
    void next() {
        ImprovingPoint second = ImprovingPoint.first(true).next();
        assertThat(second.move()).isEqualTo(0);
    }
}
