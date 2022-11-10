package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @Test
    public void 생성() {
        assertThat(new User("pobi")).isEqualTo(new User("pobi"));
    }

    @Test
    public void 이름_최대_5글자까지_가능() {
        assertThatThrownBy(() -> new User("veryLongName")).isInstanceOf(IllegalArgumentException.class);
    }
}
