package domain;

import exception.InvalidPlayerNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerNamesTest {

    @Test
    @DisplayName("스태틱 팩터리 메서드 테스트")
    void ofTest() {
        PlayerNames playerNames = PlayerNames.of("a,b,c,d");
        assertThat(playerNames.size()).isEqualTo(4);

        assertThatThrownBy(() -> {
            PlayerNames.of("a");
        }).isInstanceOf(InvalidPlayerNumberException.class);
    }
}
