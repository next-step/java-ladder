package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @DisplayName("5글자 이하의 텍스트로 이름 객체를 생성한다. ")
    @ParameterizedTest
    @ValueSource(strings = {"crong", "ABCDE", "5000", "$#$!@", "꽝"})
    void create(String name) {
        assertThat(new Name(name).getName()).isEqualTo(name);
    }

    @DisplayName("5글자를 초과하는 경우 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi123", "123456", "######"})
    void exception(String name) {
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
