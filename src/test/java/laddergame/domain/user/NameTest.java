package laddergame.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
    @DisplayName("이름 생성 테스트")
    @Test
    void create_name() {
        assertThat(new Name("pobi").getName()).isEqualTo("pobi");
    }

    @DisplayName("이름은 5자를 초과하면 안됩니다.")
    @Test
    void create_name_over_5() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name("pobiac"));
    }
}
