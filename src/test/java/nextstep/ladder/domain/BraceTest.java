package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BraceTest {
    @ParameterizedTest
    @NullSource
    @DisplayName("Brace는 빈 라인이 주어지면 예외를 던진다.")
    void newObject_null_throwsException(Point point) {
        assertThatThrownBy(
                () -> new Brace(point)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("first는 왼쪽에 false를 가진다.")
    void first_success() {
        Brace first = Brace.first();
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    @DisplayName("last는 오른쪽에 false를 가진다.")
    void last_success() {
        Brace first = Brace.first();
        Brace last = first.last();
        assertThat(last.isRight()).isFalse();
    }

    @Test
    @DisplayName("isLeft는 Point가 왼쪽에 선을 가지고 있다면 true를 반환하고 없으면 false를 반환한다.")
    void isLeft_success() {
        Brace braceLeftExisted = new Brace(new Point(true, false));
        assertThat(braceLeftExisted.isLeft()).isTrue();

        Brace braceLeftNotExisted = new Brace(new Point(false, true));
        assertThat(braceLeftNotExisted.isLeft()).isFalse();
    }

    @Test
    @DisplayName("isRight는 Point가 오른쪽에 선을 가지고 있다면 true를 반환하고 없으면 false를 반환한다.")
    void isRight_success() {
        Brace braceRightExisted = new Brace(new Point(false, true));
        assertThat(braceRightExisted.isRight()).isTrue();

        Brace braceRightNotExisted = new Brace(new Point(true, false));
        assertThat(braceRightNotExisted.isRight()).isFalse();
    }

    @Test
    @DisplayName("next의 왼쪽과 현재의 오른쪽은 같은 반환형을 가진다.")
    void next_success() {
        Brace brace = new Brace(new Point(false, true));
        Brace next = brace.next();

        assertThat(brace.isRight() && next.isLeft()).isTrue();
    }
}
