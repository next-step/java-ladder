package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayerTest {

    @Test
    void 사람_이름은_최대_5자() {
        assertThatThrownBy(()-> new Player("123456")).isInstanceOf(IllegalArgumentException.class);
    }
}
