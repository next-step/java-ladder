package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserNameTest {
    @Test
    @DisplayName("UserName 생성자 테스트")
    void constructor() {
        assertThat(new UserName("aaa")).isEqualTo(new UserName("aaa"));
    }

    @Test
    @DisplayName("이름을 최대5글자까지 부여할 수 있다.")
    void validateNameLimitFiveLength() {
        assertThatThrownBy(() -> {
                new UserName("aaaaaa");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
