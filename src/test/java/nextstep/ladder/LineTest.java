package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import nextstep.ladder.domain.Line;

public class LineTest {

    @DisplayName("곂치는 라인을 생성하지 않았는지 테스트")
    @ParameterizedTest
    @MethodSource("lineTestSource")
    public void line_generate_test(int countOfPerson, List<Boolean> points) {
        Line line = new Line(countOfPerson, () -> true);
        for(int i = 0; i < countOfPerson; i++) {
            assertThat(line.existPoint(i)).isEqualTo(points.get(i));
        }
    }

    static Stream<Arguments> lineTestSource() {
        return Stream.of(
                arguments(3, Lists.list(true, false, false)),
                arguments(1, Lists.list(false)),
                arguments(5, Lists.list(true, false, true, false, false))
        );
    }
}
