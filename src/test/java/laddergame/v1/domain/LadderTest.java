package laddergame.v1.domain;

import laddergame.v1.domain.Ladder;
import laddergame.v1.domain.LadderLineGenerator;
import laddergame.v1.domain.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {


    @DisplayName("입력받은 높이만큼의 라인을 가진 사다리를 생성한다")
    @Test
    void createLadder(){
        LadderLineGenerator generator = new RandomLineGenerator();
        Ladder ladder = new Ladder(3, 5, generator);

        assertThat(ladder.size()).isEqualTo(5);
    }

    @DisplayName("시작 위치를 선택하여 사다리 이동 후, 어느 위치까지 이동했는지 위치를 알 수 있다")
    @Test
    void moveLadder(){
        /*-------------------------
        위치 0   위치 1   위치 2
        name1   name2   name3
        |---------|       |
        [사다리 이동 결과]
        name1 : 위치 1
        name2 : 위치 0
        name3 : 위치 2
        ---------------------------*/
        LadderLineGenerator generator = (size) -> List.of(true, false);
        Ladder ladder = new Ladder(3, 1, generator);

        assertThat(ladder.moveDownByPosition(0)).isEqualTo(1);
        assertThat(ladder.moveDownByPosition(1)).isEqualTo(0);
        assertThat(ladder.moveDownByPosition(2)).isEqualTo(2);
    }
}