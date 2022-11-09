package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @DisplayName("이름 생성")
    @Test
    void name() {
        // given
        String name = "LEE";

        // when
        Name nameResult = new Name(name);

        // then
        assertThat(nameResult).isEqualTo(new Name("LEE"));
    }
}
