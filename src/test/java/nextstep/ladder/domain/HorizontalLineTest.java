package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalLineTest {

    @Test
    @DisplayName("참여하는 사람의 수 만큼 사다리의 이동 포인트가 생성된다.")
    void getPointsSize() {
        assertThat(HorizontalLine.createLineWithPoints(5).points())
                .hasSize(5);
    }

//    @RepeatedTest(100)
//    @DisplayName("초기화된 포인트들을 랜덤하게 true값으로 변경한다. 이때 연속된 true는 발생하지 않는다.")
//    void doesNotContainsContinuousTrue() {
//        List<Point> points = new HorizontalLine(5).points();
//        assertThat(IntStream.range(1, points.size())
//                .filter(index -> points.get(index) == points.get(index - 1))
//                .mapToObj(points::get)
//                .collect(Collectors.toList()))
//                .doesNotContain(true);
//    }
}
