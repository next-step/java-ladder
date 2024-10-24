package laddergame.v1.domain;

import laddergame.v1.domain.LadderLineGenerator;
import laddergame.v1.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @DisplayName("라인은 플레이어 수 - 1의 가로 길이를 가진다")
    @Test
    void lineSize(){
        int playerCount = 3;
        LadderLineGenerator generator = (size) -> List.of(true, false);
        Line line = new Line(playerCount, generator);

        assertThat(line.size()).isEqualTo(2);
    }

    @DisplayName("라인의 가로는 옆 라인과 겹칠 수 없다")
    @Test
    void validateLine(){
        List<Boolean> points = List.of(true, true, false);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(points))
                .withMessage("라인의 가로는 옆 라인과 겹칠 수 없습니다");
    }


    @DisplayName("오른쪽 칸에 가로선이 있으면 오른쪽으로 이동한다")
    @Test
    void moveRight(){
        /*-------------------
        위치0  위치1
          |-----|
        ---------------------*/
        Line line = new Line(List.of(true));

        int startPosition = 0;  //위치 0
        int currentPosition = line.move(startPosition);

        assertThat(currentPosition).isEqualTo(startPosition + 1);
    }

    @DisplayName("왼쪽, 오른쪽칸에 가로가 없으면 이동하지 않는다")
    @Test
    void moveStop(){
        /*-------------------
        위치0  위치1  위치2
          |     |     |
        ---------------------*/
        Line line = new Line(List.of(false, false));

        int startPosition = 1; // 위치 1
        int currentPosition = line.move(startPosition);

        assertThat(currentPosition).isEqualTo(startPosition);
    }

    @DisplayName("왼쪽 칸에 가로가 있으면 왼쪽으로 이동한다")
    @Test
    void moveLeft(){
        /*-------------------
        위치0  위치1  위치2
          |-----|     |
        ---------------------*/
        Line line = new Line(List.of(true, false));

        int startPosition = 1;  //위치 1
        int currentPosition = line.move(startPosition);

        assertThat(currentPosition).isEqualTo(startPosition - 1);
    }



}