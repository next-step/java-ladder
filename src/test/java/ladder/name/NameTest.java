package ladder.name;

import ladder.model.name.Name;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    public void 최소_길이_오류() {
        assertThatThrownBy(() -> Name.createUserName(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Name.createRewardName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 최대_길이_오류() {
        assertThatThrownBy(() -> Name.createUserName("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 정상_이름() {
        assertThat((Name.createUserName("12345")).toString()).isEqualTo("12345");
        assertThat((Name.createRewardName("1")).toString()).isEqualTo("1");
    }
}
