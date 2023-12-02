package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineGeneratorTest {
    @Test
    @DisplayName("blankLine은 모두 false이며 사다리 높이만큼의 크기를 가진다.")
    void test1() {
        //given
        People people = new People(List.of(
                new Name("abc"),
                new Name("def")
        ));
        Height height = new Height(2);
        LineGenerator lineGenerator = new LineGenerator(people, height);
        //when
        Line line = lineGenerator.blankLine();
        //then
        assertThat(line.point(0)).isEqualTo(Point.NO_POINT);
        assertThat(line.point(1)).isEqualTo(Point.NO_POINT);
        assertThat(line.points()).hasSize(2);
    }

    @Test
    @DisplayName("사람수만큼의 Line을 만든다.")
    void test2() {
        //given
        People people = new People(List.of(
                new Name("abc"),
                new Name("def")
        ));
        Height height = new Height(5);
        LineGenerator lineGenerator = new LineGenerator(people, height);
        //then
        assertThat(lineGenerator.generateLines()).hasSize(2);
    }
}