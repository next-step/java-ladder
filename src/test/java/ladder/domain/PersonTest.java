package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PersonTest {
    @Test
    @DisplayName("생성 테스트")
    void create() {
        assertThatCode(() -> Person.valueOf("eunji")).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("이름이 빈 값인지 확인한다.")
    void checkEmpty(String name){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Person.valueOf(name))
                .withMessageContaining("이름이 없거나 빈 값 입니다.");
    }

    @Test
    @DisplayName("이름이 5글자가 넘는 경우 에러를 발생한다.")
    void checkNameLength() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Person.valueOf("parkeunji"))
                .withMessageContaining("이름은 최대 5글자 까지 가능 합니다.");
    }
}
