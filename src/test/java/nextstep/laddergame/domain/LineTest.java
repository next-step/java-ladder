package nextstep.laddergame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @ParameterizedTest(name = "사다리의 한 라인은 연속으로 연결된 포인트를 가질 수 없다.")
    @CsvSource(value = {"true,true,false", "true,true,true", "false,true,true"})
    public void invalidLineConnectTest(boolean p1, boolean p2, boolean p3) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.of(() -> createPoints(p1, p2, p3)));
    }

    private List<Point> createPoints(boolean p1, boolean p2, boolean p3) {
        return Stream.of(p1, p2, p3)
                .map(Point::new)
                .collect(Collectors.toList());
    }

}