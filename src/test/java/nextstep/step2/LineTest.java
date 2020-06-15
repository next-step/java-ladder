package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Line;
import step2.domain.Point;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @ParameterizedTest
    @DisplayName("사람수에 따른 라인(|)수 정상 리턴하는지 테스트")
    @ValueSource(ints = {3,6,7,10})
    void makeLineTest(int countOfPerson){
        List<Point> line = Line.lineCreate(countOfPerson);
        assertThat(line.size()).isEqualTo(countOfPerson);
    }

    @ParameterizedTest
    @DisplayName("가로선을 나타내기 위한 좌표값들중 가로라인이 겹치는 경우가 있는지 테스트")
    @ValueSource(ints = {3,4,10,11})
    void verticalLineTest(int countOfPerson){
        List<Point> verticalLines = Line.lineCreate(countOfPerson);
        List<Point> filterdLines = verticalLines.stream()
                                                .filter(point -> !(point.left() && point.right()))
                                                .collect(Collectors.toList());

        assertThat(filterdLines.size()).isEqualTo(verticalLines.size());
    }
}
