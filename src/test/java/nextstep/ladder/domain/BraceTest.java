package nextstep.ladder.domain;

import nextstep.ladder.domain.concrete.Brace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BraceTest {
    @Test
    @DisplayName("Brace는 주어진 가로 라인이 겹치는 경우 예외를 던진다.")
    void newObject_null_throwsException() {
        assertThatThrownBy(
                () -> new Brace(true, true)
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
    @DisplayName("isLeft는 왼쪽에 선을 가지고 있다면 true를 반환하고 없으면 false를 반환한다.")
    void isLeft_success() {
        Brace braceLeftExisted = new Brace(true, false);
        assertThat(braceLeftExisted.isLeft()).isTrue();

        Brace braceLeftNotExisted = new Brace(false, true);
        assertThat(braceLeftNotExisted.isLeft()).isFalse();
    }

    @Test
    @DisplayName("isRight는 오른쪽에 선을 가지고 있다면 true를 반환하고 없으면 false를 반환한다.")
    void isRight_success() {
        Brace braceRightExisted = new Brace(false, true);
        assertThat(braceRightExisted.isRight()).isTrue();

        Brace braceRightNotExisted = new Brace(true, false);
        assertThat(braceRightNotExisted.isRight()).isFalse();
    }

    @Test
    @DisplayName("next의 왼쪽과 현재의 오른쪽은 같은 반환형을 가진다.")
    void next_success() {
        Brace braceRight = new Brace(false, true);
        Brace braceRightNext = braceRight.next();

        assertThat(braceRight.isRight()).isEqualTo(braceRightNext.isLeft());

        Brace braceLeft = new Brace(true, false);
        Brace braceLeftNext = braceLeft.next();

        assertThat(braceLeft.isRight()).isEqualTo(braceLeftNext.isLeft());
    }
}
