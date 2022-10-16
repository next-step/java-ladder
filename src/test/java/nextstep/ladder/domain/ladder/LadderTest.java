package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("높이만큼 라인이 생성된다.")
    @Test
    void ladder() {
        Players players = Players.create("test1", "test2", "test3");
        Ladder ladder = Ladder.create(5, players, () -> true);

        assertThat(ladder.lines()).hasSize(5);
    }
}
