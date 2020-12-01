package ladder;

import ladder.model.Name;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    public void 최소_길이_오류() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 최대_길이_오류() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 정상_이름() {
        assertThat((new Name("12345")).toString()).isEqualTo("12345");
    }
}
