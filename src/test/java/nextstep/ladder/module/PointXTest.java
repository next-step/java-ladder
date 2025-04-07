package nextstep.ladder.module;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointXTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Test
    @DisplayName("x가 0 미만이면 에러")
    void givenXLessThanZero_whenCreatePointX_thenThrowException() {
        assertThatThrownBy(() -> new PointX(-1, new Ladder())).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("x는 0 이상이어야 합니다.");
    }
    
    @Test
    @DisplayName("x가 0 이상이면 통과")
    void givenXGreaterThanOrEqualToZero_whenCreatePointX_thenPass() {
        assertThat(new PointX(0, new Ladder()).value()).isEqualTo(0);
    }

    @Test
    @DisplayName("ladder 가 있을 때 출력 점검")
    void givenLadder_whenToString_thenPrintLadder() {
        PointX pointX = new PointX(0, new Ladder(true));
        System.setOut(new PrintStream(outputStream));
        System.out.printf("%s", pointX);
        assertThat(outputStream.toString()).isEqualTo("-----|");
    }

    @Test
    @DisplayName("ladder 가 없을 때 출력 점검")
    void givenNoLadder_whenToString_thenPrintNoLadder() {
        PointX pointX = new PointX(0);
        System.setOut(new PrintStream(outputStream));
        System.out.printf("%s", pointX);
        assertThat(outputStream.toString()).isEqualTo("     |");
    }
   
}
