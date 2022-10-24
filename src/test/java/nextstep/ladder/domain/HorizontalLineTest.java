package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HorizontalLineTest {

    @Test
    @DisplayName("참여하는 사람의 수 만큼 사다리의 이동 포인트가 생성된다.")
    void getPointsSize() {
        assertThat(new HorizontalLine(5).points())
                .hasSize(5);
    }

    @Test
    @DisplayName("참여하는 사람의 수 만큼 사다리의 이동 포인트가 생성된 후에 false로 초기화 된다.")
    void initialPoints() {
        assertThat(new HorizontalLine(5).points())
                .allMatch(Predicate.isEqual(false));
    }

    @RepeatedTest(100)
    @DisplayName("초기화된 포인트들을 랜덤하게 true값으로 변경한다. 이때 연속된 true는 발생하지 않는다.")
    void doesNotContainsContinuousTrue() {
        List<Boolean> points = new HorizontalLine(5).generatePoint()
                .points();
        assertThat(IntStream.range(1, points.size())
                .filter(index -> points.get(index) == points.get(index - 1))
                .mapToObj(points::get)
                .collect(Collectors.toList()))
                .doesNotContain(true);
    }
}
