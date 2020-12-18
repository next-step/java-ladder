package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("참가자수 4명, 높이가 5인 사다리에 모든 사다리가 생성되지 않으면(false) 0,1,2,3 순으로 index가 나온다.")
    void should_return_ladder_when_false() {
        //Given
        LadderSize ladderSize = new LadderSize(4, 5);

        //When
        Ladder ladder = new Ladder(ladderSize);
        List<Integer> run = ladder.run();

        //Then
        assertThat(run).containsAll(Arrays.asList(0, 1, 2, 3));

    }

    @Test
    @DisplayName("참가자수 4명, 높이가 5인 사다리에 모든 사다리가 생성되면(true), 1,0,3,2 순으로 in으dex가 나온다.")
    void should_return_ladder_when_true() {
        //Given
        LadderSize ladderSize = new LadderSize(4, 5);

        //When
        Ladder ladder = new Ladder(ladderSize);
        List<Integer> run = ladder.run();

        //Then
        assertThat(run).containsAll(Arrays.asList(1, 0, 3, 2));

    }

}
