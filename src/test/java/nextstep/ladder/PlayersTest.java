package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Players;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @Test
    public void 플레이어의_이름은_쉼표로_구분한다() {
        String names = "pobi,crong,jk";
        Players players = Players.of(names);
        assertThat(players.getPlayers().stream()
            .map(Person::name)
            .distinct()
            .collect(Collectors.toList()))
            .containsExactly("pobi", "crong", "jk");
    }

    @Test
    public void 플레이어의_인덱스정보를_가져온다() {
        String names = "pobi,crong,jk";
        Players players = Players.of(names);
        assertThat(players.findPlayerIndex("pobi")).isEqualTo(0);
        assertThat(players.findPlayerIndex("crong")).isEqualTo(1);
        assertThat(players.findPlayerIndex("jk")).isEqualTo(2);
    }
}
