package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PersonTest {
    @Test
    @DisplayName("생성 테스트")
    void create() {
        assertThatCode(() -> Person.from("eunji")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이름이 5글자가 넘는 경우 에러를 발생한다.")
    void checkNameLength() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Person.from("parkeunji"))
                .withMessageContaining("이름은 최대 5글자 까지 가능 합니다.");
    }
}
