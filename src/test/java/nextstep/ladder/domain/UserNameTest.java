package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserNameTest {

    @DisplayName("사용자 이름은 5글자를 초과하면 에러를 던진다.")
    @Test
    void 이름_길이_초과시_에러() {
        assertThatThrownBy(() -> new UserName("kimmin")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "userName 클래스 생성시 전달한 파라미터로 값이 할당되 있어야 한다.")
    @ValueSource(strings = {"kim", "min"})
    void 이름_검증(String userName) {
        assertThat(new UserName(userName).getName()).isEqualTo(userName);
    }

}