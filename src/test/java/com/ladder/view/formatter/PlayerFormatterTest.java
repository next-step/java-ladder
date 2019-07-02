package com.ladder.view.formatter;

import com.ladder.model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ladder.model.PlayerTest.ofPlayer;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerFormatterTest {

    private Formatter<Player> userNameFormatter = new PlayerFormatter();

    @DisplayName("사다리 위치에 맞게 이름 앞에 공백을 추가한다")
    @Test
    void printUserName_success() {
        // given
        Player player = ofPlayer("pobi");
        String expected = "  pobi";

        // when
        String result = userNameFormatter.format(player);

        // then
        assertThat(result).isEqualTo(expected);
    }
}