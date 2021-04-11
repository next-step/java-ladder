package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MemberTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdef","1234556"})
    @DisplayName("이름을 5자 이상 입력하면 오류발생")
    void memberNameTest(String name){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Member(name))
                .withMessage("이름은 5자까지 가능합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 공백이거나 null이면 오류 발생")
    void memberNameTest2(String name){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Member(name))
                .withMessage("이름을 입력해주세요.");
    }
}