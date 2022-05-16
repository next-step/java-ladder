package nextstep.ladder.domain.person;

import nextstep.ladder.domain.person.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("이름이 1 ~ 5글자면 정상적으로 생성된다.")
    @Test
    void createNameTest() {
        new Name("넥스트스텝");
    }

    @DisplayName("이름이 1 ~ 5글자가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "Hello TDD"})
    void createNameTestFail(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}