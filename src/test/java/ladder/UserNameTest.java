package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserNameTest {
    @Test
    void 이름_생성() {
        UserName userName = new UserName("hwan2");
        assertThat(userName).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "hwan22"})
    void 이름_길이_검증(String value) {
        assertThatThrownBy(() -> new UserName(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}