package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class LineTest {

    static class TestPoint implements Point{
        public int size;
        public TestPoint(String names) {
            size = names.split(",").length;
        }

        @Override
        public List<Boolean> generatePoints() {
            ArrayList<Boolean> points = new ArrayList<>();
            for(int i =0; i < size; i++){
                points.add(true);
            }
            return points;
        }
    }

    static Stream<Arguments> inputLine() {
        return Stream.of(
                Arguments.of("pobi,honux", List.of(true,true)),
                Arguments.of("pobi,honux,koko", List.of(true,true,true))
        );
    }

    @ParameterizedTest
    @DisplayName("하나의 라인은 (참여자들 -1)개만큼의 boolean 값들이 존재(pobi,honux => true,true/ pobi,hounx,koko => true,true,true)")
    @MethodSource("inputLine")
    void line_size(String names, List<Boolean> result) {
        Line line = new Line(new TestPoint(names));
        assertThat(line).isEqualTo(new Line(result));
    }
}
