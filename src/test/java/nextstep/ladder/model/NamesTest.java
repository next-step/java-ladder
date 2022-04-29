package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("이름들")
class NamesTest {

    @Test
    @DisplayName("쉼표로 구분된 문자열로 이름들 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Names.from("a,b,c,d"));
    }

    @ParameterizedTest(name = "[{index}] {0} 값으로 이름들 생성 불가")
    @DisplayName("문자열은 필수")
    @NullAndEmptySource
    void instance_nullOrEmpty_thrownIllegalArgumentException(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Names.from(name));
    }

    @ParameterizedTest(name = "[{index}] {0} 로 이름들을 생성하면 크기는 {1}")
    @DisplayName("크기")
    @CsvSource(value = {"a;1", "a,b,c,d;4"}, delimiter = ';')
    void size(String names, int expected) {
        assertThat(Names.from(names).size()).isEqualTo(expected);
    }

    @Test
    @DisplayName("주어진 이름 구분해서 반환")
    void list() {
        assertThat(Names.from("a,b,c").list()).containsExactly(Name.from("a"), Name.from("b"), Name.from("c"));
    }
}
