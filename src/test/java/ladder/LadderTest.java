package ladder;

import ladder.domain.Ladder;
import ladder.domain.PlayersGroup;
import ladder.domain.RandomDrawingLineStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private PlayersGroup playersGroup;

    @BeforeEach
    public void setupPlayersGroup() {
        List<String> playerList = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        playersGroup = PlayersGroup.of(playerList);
    }

    @DisplayName("Ladder 객체 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    public void makeLadderObject(int ladderHeight) {
        Ladder ladder = Ladder.buildLadder(playersGroup, ladderHeight, new RandomDrawingLineStrategy());

        assertThat(ladder.getLadderHeight())
                .isEqualTo(ladderHeight);

        assertThat(ladder.getLadderBluePrint().size())
                .isEqualTo(ladderHeight);

        assertThat(ladder.getLadderBluePrint().get(0).size())
                .isEqualTo(playersGroup.getPlayerCounts());
    }
}

