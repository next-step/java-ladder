package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class LineTest {

    static Stream<Arguments> getLineResult(){
        return Stream.of(
                Arguments.of("pobi,honux", List.of(true,true)),
                Arguments.of("pobi,honux,koko", List.of(true,true,true))
        );
    }

    static class TestPointGenerator implements PointGenerator{

        @Override
        public Boolean generate() {
            return true;
        }
    }

    @ParameterizedTest
    @DisplayName("하나의 라인은 (참여자들 -1)개만큼의 boolean 값들이 존재(pobi,honux => ture,true/ pobi,hounx,koko => true,true,true)")
    @MethodSource("getLineResult")
    void line_size(String names, List<Boolean> result) {
        Line line = new Line(new Participant(names), new TestPointGenerator());
        assertThat(line).isEqualTo(new Line(result));
    }
}
