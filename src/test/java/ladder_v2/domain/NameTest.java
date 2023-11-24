package ladder_v2.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("이름은 5자 이하여야 합니다.")
    void testName() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name("pobicon");
        });
    }

}
