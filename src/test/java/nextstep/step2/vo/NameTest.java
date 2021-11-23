package nextstep.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @DisplayName("이름은 널이나 빈 값이 올 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Name.create(input));
    }

    @DisplayName("이름은 5자를 초과한 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef"})
    void rangeTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Name.create(input));
    }

    @DisplayName("정상 생성 테스트")
    @Test
    void createTest() {
        assertThat(Name.create("miz")).isEqualTo(Name.create("miz"));
    }

    @DisplayName("length()는 이름의 길이를 반환한다.")
    @Test
    void lengthTest() {
        assertThat(Name.create("miz").length()).isEqualTo(3);
    }

}
