package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @Test
    @DisplayName("사람 이름이 5글자 초과할 경우")
    void LadderCreator() {
        String[] personNames = {"a", "watermelon", "c"};

        assertThatThrownBy(() -> {
            new Players(personNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람 이름은 최대 5글자까지 입니다.");
    }

}
