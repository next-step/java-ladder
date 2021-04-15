package ladder;

import ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @DisplayName("참가자를 생성한다.")
    @Test
    void create() {
        Player player = new Player("apple");
        assertThat(player).isEqualTo(new Player("apple"));
    }

    @DisplayName("참가자명이 5글자를 넘어가면 예외를 반환한다.")
    @Test
    void invalid() {
        assertThatThrownBy(() -> {
            new Player("apples");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
