package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 빈 값이거나 null일 경우 예외처리")
    void nullOrEmptyTest(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "go", "iam", "test", "given"})
    @DisplayName("이름 생성 테스트")
    void nameTest(String input) {
        Name name = new Name(input);

        assertThat(name.getName())
                .isEqualTo(input);
    }

    @Test
    @DisplayName("이름이 5자 초과일 경우 에러 반환 테스트")
    void moreFiveNameErrorTest() {
        assertThatThrownBy(() -> new Name("python"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }

}
