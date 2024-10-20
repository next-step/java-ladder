package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @Test
    @DisplayName("이름이 5자 초과일 경우 예외를 발생시킨다.")
    void 이름이5자초과() {
        Assertions.assertThatThrownBy(() -> new Member("asdasd"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
