package nextstep.ladder.step3.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import nextstep.ladder.step3.domain.Category;
import nextstep.ladder.step3.domain.Height;
import nextstep.ladder.step3.domain.InputString;
import nextstep.ladder.step3.domain.Ladder;
import nextstep.ladder.step3.domain.Name;
import nextstep.ladder.step3.domain.Players;
import nextstep.ladder.step3.service.LadderGame;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @Test
    void 게임진행() {
        // given
        Players players = Players.of(new InputString("kim,dong,hyo"));
        Ladder ladder = Ladder.of(players.width(), new Height(5), () -> true);
        Category category = Category.of(new InputString("꽝,성공,꽝"), players);

        // when
        Map<Name, Name> nameStringMap = LadderGame.gamePlay(players, ladder, category);

        // then
        Map<Name, Name> validation = new LinkedHashMap<>();
        validation.put(players.getPlayer(0), Name.of("성공"));
        validation.put(players.getPlayer(1), Name.of("꽝"));
        validation.put(players.getPlayer(2), Name.of("꽝"));

        assertThat(nameStringMap).isEqualTo(validation);
    }

}
