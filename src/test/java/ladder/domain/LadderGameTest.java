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
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    @Test
    public void createInstanceTest(){
        //Given & When
        Participants participants = Participants.of(Arrays.asList("user","user2","user3"));
        Ladder ladder = LadderFactory.makeLadder(new LadderStructure(5,4), new RandomLineGenerator());
        LadderGame ladderGame = new LadderGame(participants, ladder);

        //Then
        assertThat(ladderGame.play(new Rewards(Arrays.asList("test","test2","test3")))).isNotNull();
    }

    @Test
    public void gamePlayTest() {
        //Given
        Participants participants = Participants.of(Arrays.asList("user1","user2","user3"));
        Ladder ladder = LadderFactory.makeLadder(new LadderStructure(4,3), new RandomLineGenerator());
        LadderGame ladderGame = new LadderGame(participants, ladder);

        //When
        GameResult gameResult = ladderGame.play(new Rewards(Arrays.asList("꽝","3000","3000")));

        //Then
        assertThat(gameResult.search("user1")).isNotNull();
    }

    @Test
    public void canNotPlayGameTest() {
        assertThatThrownBy(() ->
              new LadderGame(Participants.of(Arrays.asList("test","test2")), null).play(new Rewards(Arrays.asList("test")))
        ).isInstanceOf(CanNotPlayGameException.class);
    }

    @Test
    public void getLadderMaterial() {
        //Given
        Participants participants = Participants.of(Arrays.asList("user1","user2","user3"));
        Ladder ladder = LadderFactory.makeLadder(new LadderStructure(4,3), new RandomLineGenerator());
        LadderGame ladderGame = new LadderGame(participants, ladder);

        //When
        LadderMaterial ladderMaterial = ladderGame.getLadderMaterial();

        //Then
        assertThat(ladderMaterial.getParticipantNames()).containsAll(participants.getParticipantNames());
    }
}