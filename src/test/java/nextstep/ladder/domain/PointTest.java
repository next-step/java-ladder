package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    @DisplayName("Point는 주어진 가로 라인이 겹치는 경우 예외를 던진다")
    void newObject_twoLinesAttached_throwsException() {
        assertThatThrownBy(
                () -> new Point(true, true)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("first는 왼쪽에 false를 가진다.")
    void first_success() {
        Point first = Point.first();
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    @DisplayName("last는 오른쪽에 false를 가진다.")
    void last_success() {
        Point first = Point.first();
        Point last = first.last();
        assertThat(last.isRight()).isFalse();
    }

    @Test
    @DisplayName("isLeft는 왼쪽에 선을 가지고 있다면 true를 반환하고 없으면 false를 반환한다.")
    void isLeft_success() {
        Point pointLeftExisted = new Point(true, false);
        assertThat(pointLeftExisted.isLeft()).isTrue();

        Point pointRightExisted = new Point(false, true);
        assertThat(pointRightExisted.isLeft()).isFalse();
    }

    @Test
    @DisplayName("isRight는 Point가 오른쪽에 선을 가지고 있다면 true를 반환하고 없으면 false를 반환한다.")
    void isRight_success() {
        Point pointRightExisted = new Point(false, true);
        assertThat(pointRightExisted.isRight()).isTrue();

        Point pointRightNotExisted = new Point(true, false);
        assertThat(pointRightNotExisted.isRight()).isFalse();
    }

    @Test
    @DisplayName("next의 왼쪽과 현재의 오른쪽은 같은 반환형을 가진다.")
    void next_success() {
        Point point = new Point(true, false);
        Point next = point.next();

        assertThat(!point.isRight() && !next.isLeft()).isTrue();
    }
}
