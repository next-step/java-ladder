package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonNameTest {

    @Test
    void 이름은_5자를_초과할_수_없다() {
        assertThatThrownBy(() -> new PersonName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void getName() {
        String expect = "abcd";
        PersonName personName = new PersonName(expect);
        assertThat(personName.getName())
                .isEqualTo(expect);
    }
}