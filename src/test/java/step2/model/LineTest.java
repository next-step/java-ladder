package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 한 층을 나타내는 Line 테스트")
public class LineTest {
    private Line line;

    @Test
    @DisplayName("Line 생성 테스트")
    void create_Line_With_AllLine() {
        line = new Line();
        assertThat(line.printRungs()).isEqualTo("[]");
    }

    @Test
    @DisplayName("Line 전략주입 테스트 : All true가 나오는 조건이면 false 값은 없는가?")
    void create_Line_With_Draw_Strategy() {
        line = new Line();
        line.drawNewLine(5, () -> true);
        assertThat(line.printRungs()).doesNotContain("false");
    }

    @Test
    @DisplayName("Line의 제약조건 : 한 구역의 -----가 그려졌다면 다음 구역은 무조건 Null인가?")
    void create_Line_For_Constraint() {
        line = new Line();
        line.drawNewLine(2, () -> true);
        assertThat(line.draw(()->true)).isEqualTo(false);
    }

    @Test
    @DisplayName("Line의 제약조건 : 전략 주입이 제대로 잘 구현되었는가? 강제로 true 전략 입력시 false 다음 true가 나오는가?")
    void create_Line_For_Constraint_with_Drawed() {
        line = new Line();
        line.drawNewLine(2, () -> false);
        assertThat(line.draw(()->true)).isEqualTo(true);
    }

    @Test
    void create_Line_With_N_Count() {
        line = new Line();
        line.drawNewLine(4, () -> true);
        System.out.println(line.printRungs());
        //assertThat(line.draw(()->true)).isEqualTo(true);
    }
}
