package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerNameTest {

    @DisplayName("이름이 최대 글자수를 넘기면 IllegalArgumentException")
    @Test
    void maxLength() {
        assertThatThrownBy(() -> PlayerName.of("name123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
