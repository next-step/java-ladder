package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("players가 null이면 NullPointerException")
    @Test
    void nullPlayers() {
        assertThatThrownBy(() -> new Ladder(null, LadderHeight.of(3)))
                .isInstanceOf(NullPointerException.class);
    }

    @DisplayName("ladderHeight이 null이면 NullPointerException")
    @Test
    void nullLadderHeight() {
        Players players = Players.of(Arrays.asList(Player.of("name1"), Player.of("name2")));

        assertThatThrownBy(() -> new Ladder(players, null))
                .isInstanceOf(NullPointerException.class);
    }

    @DisplayName("입력한 사다리의 높이만큼 사다리의 라인이 그려진다")
    @Test
    void ladderLinesSize() {
        Players players = Players.of(Arrays.asList(Player.of("name1"), Player.of("name2")));
        LadderHeight ladderHeight = LadderHeight.of(3);

        Ladder ladder = new Ladder(players, ladderHeight);
        LadderLines ladderLines = ladder.getLadderLines();

        assertThat(LadderHeight.of(ladderLines.size())).isEqualTo(ladderHeight);
    }
}
