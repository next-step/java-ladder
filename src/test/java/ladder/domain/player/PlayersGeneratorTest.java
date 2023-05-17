package ladder.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayersGeneratorTest {
    @Test
    void 쉼표로_구분된_문자열로_플레이어들을_만들_수_있다() {
        String playerNames = "pobi,honux,crong,jk";
        Players players = PlayersGenerator.create(playerNames);
        assertThat(players.getPlayerList()
                .stream()
                .map(Player::getName)
                .toArray()
        ).containsExactly("pobi", "honux", "crong", "jk");
    }
}
