package ladder;

import ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @DisplayName("사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다.")
    @Test
    void validatePlayerNameException() {
        assertThat(new Player("abcde")).isEqualTo(new Player("abcde"));
        assertThatThrownBy(() -> {
            new Player("abcdea");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.")
    @Test
    void alidatePlayerName() {
        String name = String.format("%" + Player.NAME_LIMIT + "s",
                            new Player("abc").getName());
        assertThat(name.length()).isEqualTo(Player.NAME_LIMIT);
    }
}
