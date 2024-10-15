package laddergame.domain;

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

        LadderLineStatusGenerator generator = () -> true;
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
}