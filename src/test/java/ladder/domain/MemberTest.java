package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MemberTest {

    @Test
    @DisplayName("생성자로 이름을 생성한다.")
    void 이름_생성() {
        assertThat(new Member("asda").getName()).isEqualTo("asda");
    }

    @Test
    @DisplayName("이름이 5자 초과일 경우 예외를 발생시킨다.")
    void 이름이5자초과() {
        assertThatThrownBy(() -> new Member("asdasd"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
