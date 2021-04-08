package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void create() {
        // given
        String nameString = "snow";

        // when
        Name name = Name.from(nameString);

        // then
        assertThat(name).isEqualTo(Name.from(nameString));
    }

    @Test
    @DisplayName("이름 5자 초과시 예외 발생한다.")
    void create_name_length_exceeded() {
        assertThatThrownBy(() -> Name.from("soonho"))
                .isInstanceOf(RuntimeException.class);
    }
}