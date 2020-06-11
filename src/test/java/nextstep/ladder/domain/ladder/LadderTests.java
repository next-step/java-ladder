package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exceptions.InvalidLadderHeightException;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTests {
    private PointAddStrategy simplePointAddStrategy;

    @BeforeEach
    public void setup() {
        simplePointAddStrategy = new SimplePointAddStrategy();
    }

    @DisplayName("사다리의 최대 높이를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        int ladderHeight = 5;
        int countOfPerson = 3;
        Ladder ladder = Ladder.create(ladderHeight, countOfPerson, simplePointAddStrategy);
        assertThat(ladder.getHeight()).isEqualTo(ladderHeight);
    }

    @DisplayName("사다리의 최대 높이를 0으로 객체 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void createValidationTest(int invalidLadderHeight) {
        int countOfPerson = 3;
        assertThatThrownBy(() -> Ladder.create(invalidLadderHeight, countOfPerson, simplePointAddStrategy))
                .isInstanceOf(InvalidLadderHeightException.class);
    }

    @DisplayName("전달받은 Player의 Ladder Game을 진행할 수 있다.")
    @Test
    void doLadderGameTest() {
        int ladderHeight = 5;
        int countOfPerson = 3;
        Ladder ladder = Ladder.create(ladderHeight, countOfPerson, simplePointAddStrategy);
        Player player = new Player("poppo", new HorizontalLocation(1, countOfPerson));

        ladder.playGame(player);

        assertThat(player.getHorizontalLocation()).isEqualTo(new HorizontalLocation(0, countOfPerson));
    }

    @DisplayName("모든 Player의 Ladder Game을 진행할 수 있다.")
    @Test
    void doLadderGameAllPlayerTest() {
        int ladderHeight = 5;
        int countOfPerson = 3;
        Ladder ladder = Ladder.create(ladderHeight, countOfPerson, simplePointAddStrategy);
        Players players = Players.create(Arrays.asList("saul", "poppo", "ita"));

        ladder.playGameWithAllPlayers(players);

        assertThat(players.getLocationOfIndex(0)).isEqualTo(new HorizontalLocation(1, countOfPerson));
        assertThat(players.getLocationOfIndex(1)).isEqualTo(new HorizontalLocation(0, countOfPerson));
        assertThat(players.getLocationOfIndex(2)).isEqualTo(new HorizontalLocation(2, countOfPerson));
    }
}
