package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RandomGeneratorLadderMover;
import ladder.exception.InsufficientParticipantsCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    @Test
    public void createInstanceTest() {
        //Given & When
        LadderGame ladderGame = new LadderGame(new RandomGeneratorLadderMover());

        ladderGame.participatePeople(Arrays.asList("유저1", "유저2", "유저3"));

        //Then
        assertThat(ladderGame).isNotNull();
    }

    @DisplayName("1명의 참가자만 참여시킬 경우 예외처리 테스트")
    @Test
    public void participateOnePerson() {
        assertThatThrownBy(() ->
                new LadderGame(new RandomGeneratorLadderMover()).participatePeople(Arrays.asList("유저"))
        ).isInstanceOf(InsufficientParticipantsCountException.class);
    }


    @ParameterizedTest
    @CsvSource(value = {"3:5", "2:6", "5:3", "6:12"}, delimiter = ':')
    public void makeLadderTest(int width, int height) {
        //Given
        LadderGame game = new LadderGame(new RandomGeneratorLadderMover());

        //When
        Ladder ladder = game.makeLadder(width, height);

        //Then
        assertThat(ladder.sizeWidth()).isEqualTo(width);
        assertThat(ladder.sizeHeight()).isEqualTo(height);
    }


}
