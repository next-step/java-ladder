package nextstep.ladder.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import nextstep.ladder.domain.Category;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Item;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.StringAsCategory;
import nextstep.ladder.domain.StringAsPlayers;
import nextstep.ladder.service.LadderGame;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @Test
    void 게임진행() {
        // given
        Players players = new StringAsPlayers("kim,dong,hyo").players();
        Ladder ladder = Ladder.of(players.width(), new Height(5), () -> true);
        Category category = new StringAsCategory("꽝,성공,꽝").category(players);

        // when
        LadderGame ladderGame = LadderGame.getInstance();
        Map<Name, Item> nameStringMap = ladderGame.gamePlay(players, ladder, category);

        // then
        Map<Name, Item> validation = new LinkedHashMap<>();
        validation.put(players.getPlayer(0), new Item("성공"));
        validation.put(players.getPlayer(1), new Item("꽝"));
        validation.put(players.getPlayer(2), new Item("꽝"));

        assertThat(nameStringMap).isEqualTo(validation);
    }

}
