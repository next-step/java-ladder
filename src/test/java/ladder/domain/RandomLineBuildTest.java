package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLineBuildTest {

    @DisplayName("마지막 사다리는 이어지는 라인이 없도록 처리 테스트")
    @Test
    void lastLadderAlwaysNotConnectedTest(){

        int countOfPlayer = 5;
        LineBuildStrategy lineBuildStrategy = new RandomLineBuildStrategy();
        Line line = lineBuildStrategy.build(countOfPlayer);


        // then
        assertThat(line.getPoints().get(countOfPlayer-1).getDirection().isRight()).isFalse();
    }
}
