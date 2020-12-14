package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사람 이름, 사다리 높이를 입력 받아 사다리 생성")
    void should_return_ladders() {

        //Given
        Participants participants = new Participants("pobi,honux,crong,jk");
        int ladderHeight = 10;

        //When
        Ladder ladder = new Ladder(participants.size(), new LadderHeight(ladderHeight), () -> new Random().nextBoolean());

        //Then
        assertThat(ladder.getLadderLines().size()).isEqualTo(ladderHeight);
        assertThat(ladder.getLadderLines().get(0).getPoints().size()).isEqualTo(7);
    }

    @Test
    @DisplayName("사다리 game을 실행하여 결과를 얻어낸다.")
    void should_return_game_result() {
        //Given
        Participants participants = new Participants("pobi,honux,crong,jk");
        int ladderHeight = 5;

        //When
        Ladder ladder = new Ladder(participants.size(), new LadderHeight(ladderHeight), () -> new Random().nextBoolean());

        //Then
        ladder.run();
    }


    @Test
    @DisplayName("사다리가 모두 생성되지 않으면(false), index가 그대로 나온다.")
    void should_return_ladder_when_false() {
        //Given
        Participants participants = new Participants("pobi,honux,crong,jk");
        int ladderHeight = 5;
        Ladder ladder = new Ladder(participants.size(), new LadderHeight(ladderHeight), () -> false);

        //When
        List<Integer> run = ladder.run();

        //Then
        assertThat(run).containsAll(Arrays.asList(0, 1, 2, 3));

    }

    @Test
    @DisplayName("사다리가 전부 생성 되면, index가 그대로 나온다.")
    void should_return_ladder_when_true() {
        //Given
        Participants participants = new Participants("pobi,honux,crong,jk");
        int ladderHeight = 5;
        Ladder ladder = new Ladder(participants.size(), new LadderHeight(ladderHeight), () -> true);

        //When
        List<Integer> run = ladder.run();

        //Then
        assertThat(run).containsAll(Arrays.asList(1, 0, 3, 2));

    }

}
