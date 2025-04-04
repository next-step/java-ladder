package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
    @DisplayName("이름 유효성 검사 테스트")
    @Test
    void create_user() {
        assertThat(new Name("pobi").getName()).isEqualTo("pobi");
        assertThatIllegalArgumentException().isThrownBy(() -> new Name("pobiac"));
    }
}
