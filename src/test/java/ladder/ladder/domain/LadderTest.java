package ladder.ladder.domain;

import ladder.player.domain.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    private List<String> stubPlayerNames;

    @BeforeEach
    void setUp() {
        stubPlayerNames = asList("jwee0330", "jayden");
    }

    @DisplayName("높이와 참여자의 수를 입력하면 사다리를 생성할 수 있다.")
    @Test
    public void newLadderTest() {
        Ladder ladder = Ladder.of(5, Players.of(stubPlayerNames));

        List<LadderLine> fourLinesLadder = ladder.getLadderLines();

        assertThat(fourLinesLadder).hasSize(stubPlayerNames.size());
        assertThatThrownBy(() -> fourLinesLadder.get(5)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("사다리의 높이는 1보다 커야 한다.")
    @Test
    public void newLadderWithMinusHeightTest() {
        assertThatThrownBy(() -> Ladder.of(0, Players.of(stubPlayerNames)))
                .isInstanceOf(InvalidHeightException.class)
                .hasMessageContaining("높이는 1보다 커야 합니다.");
    }

}
