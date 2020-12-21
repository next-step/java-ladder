package ladder.domain;

import ladder.domain.dto.GameResult;
import ladder.domain.dto.LadderMaterial;
import ladder.domain.dto.Rewards;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderFactory;
import ladder.domain.ladder.LadderStructure;
import ladder.domain.ladder.RandomLineGenerator;
import ladder.domain.participant.Participants;
import ladder.exception.CanNotPlayGameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    private LadderGame ladderGame;
    private Participants participants;
    private Ladder ladder;

    @BeforeEach
    public void setUp() {
        this.participants = Participants.of(Arrays.asList("user", "user2", "user3"));
        this.ladder = LadderFactory.makeLadder(new LadderStructure(3, 4), new RandomLineGenerator());
        this.ladderGame = new LadderGame(participants, ladder);
    }


    @Test
    public void createInstanceTest() {
        assertThat(ladderGame.play(new Rewards(Arrays.asList("test", "test2", "test3")))).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"user", "user2", "user3"})
    public void gamePlayTest(String searchName) {
        //Given & When
        GameResult gameResult = ladderGame.play(new Rewards(Arrays.asList("꽝", "3000", "3000")));

        //Then
        assertThat(gameResult.search(searchName)).isNotNull();
    }

    @Test
    public void canNotPlayGameTest() {
        assertThatThrownBy(() ->
                new LadderGame(Participants.of(Arrays.asList("test", "test2")), null).play(new Rewards(Arrays.asList("test")))
        ).isInstanceOf(CanNotPlayGameException.class);
    }

    @Test
    public void getLadderMaterial() {
        //Given & When
        LadderMaterial ladderMaterial = ladderGame.getLadderMaterial();

        //Then
        assertThat(ladderMaterial.getParticipantNames()).containsAll(participants.getParticipantNames());
    }
}