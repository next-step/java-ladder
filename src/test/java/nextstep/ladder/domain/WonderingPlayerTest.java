package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WonderingPlayerTest {

    @ParameterizedTest(name = "isNotAll 테스트 | {arguments}")
    @CsvSource(value = {"iiaii|true", "all|false"}, delimiter = '|')
    public void isNotAll(String input, boolean expected) {
        // given
        WonderingPlayer wonderingPlayer = new WonderingPlayer(input);

        // when
        boolean notAll = wonderingPlayer.isNotAll();

        // then
        assertThat(notAll).isEqualTo(expected);
    }

    @Test
    @DisplayName("getWonderingPlayer 테스트")
    public void getWonderingPlayer() {
        // given
        WonderingPlayer wonderingPlayer = new WonderingPlayer("iiaii");
        Player expected = new Player("iiaii");

        // when
        Player player = wonderingPlayer.getWonderingPlayer();

        // then
        assertThat(player).isEqualTo(expected);
    }

}