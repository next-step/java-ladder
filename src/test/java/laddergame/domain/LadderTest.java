package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {


    @DisplayName("입력받은 높이만큼의 라인을 가진 사다리를 생성한다")
    @Test
    void createLadder(){
        LadderLineGenerator generator = new RandomLineGenerator();
        Ladder ladder = new Ladder(3, 5, generator);

        assertThat(ladder.size()).isEqualTo(5);
    }
}