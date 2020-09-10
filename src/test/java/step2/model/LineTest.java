package step2.model;

import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.Morph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 한 층을 나타내는 Line 테스트")
public class LineTest {
    private Line line;

    private static Stream<Arguments> lineValueForMoveTest() {
        return Stream.of(
                Arguments.of(4, "John", 2, 3),
                Arguments.of(5, "Jay", 0, 1),
                Arguments.of(4, "Kim", 3, 2)
        );
    }

    @Test
    @DisplayName("Line 생성 테스트")
    void create_Line_With_AllLine() {
        line = new Line();
        assertThat(line.printRungs()).isEqualTo("[]");
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
        assertThat(line.draw(() -> true)).isEqualTo(true);
    }

    @Test
    void create_Line_With_N_Count() {
        line = new Line();
        line.drawNewLine(4, () -> true);
        System.out.println(line.printRungs());
        //assertThat(line.draw(()->true)).isEqualTo(true);
    }

    @ParameterizedTest
    @MethodSource("lineValueForMoveTest")
    void create_Line_And_Person_And_Check_The_Position(int value, String name, int position, int expected) {
        line = new Line();
        line.drawNewLine(value, () -> true);
        Person person = Person.of(name, position);
        line.move(person);
        System.out.println(line.printRungs());
        assertThat(person.printCurrentPosition().getPosition()).isEqualTo(expected);
    }
}
