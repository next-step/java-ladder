package nextstep.ladder.domain.player;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderLine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerGroupTest {

    @Test
    void create() {
        PlayerGroup playerGroup = new PlayerGroup("pobi,crong,jk,jason");

        assertThat(playerGroup).isEqualTo(new PlayerGroup(
                List.of(new Player("pobi", 0),
                        new Player("crong", 1),
                        new Player("jk", 2),
                        new Player("jason", 3))));
    }

    @Test
    void throwExceptionIfPlayerNameIsEmpty() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerGroup(""));
    }

    @Test
    void throwExceptionIfPlayerNameLengthExceedFive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerGroup("pobisdfsd,honux,crong,jk"));
    }

    @Test
    void playLadderGame() {
        PlayerGroup playerGroup = new PlayerGroup("pobi,honux,crong,jk");

        Ladder ladder = new Ladder(List.of(
                new LadderLine(List.of(true, false, false)),
                new LadderLine(List.of(true, false, false)),
                new LadderLine(List.of(true, false, true))));

        List<Player> result = playerGroup.play(ladder);

        assertThat(result).containsExactly(
                new Player("pobi", 1),
                new Player("honux", 0),
                new Player("crong", 3),
                new Player("jk", 2));
    }
}
