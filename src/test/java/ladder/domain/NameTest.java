package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @DisplayName("생성")
    @Test
    void create() {
        Name name = new Name("jenny");
        assertThat(name).isEqualTo(new Name("jenny"));
    }

    @DisplayName("이름이 5자 초과시 IllegalArgumentException 발생")
    @Test
    void create_ThrowsIllegalArgumentException_IfNameSizeUpperThanFive() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Name("madrid")
        );
    }
}