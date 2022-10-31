package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class RandomLineGeneratorTest {

    @DisplayName("마지막 위치의 Point 연결은 무조건 false 반환")
    @ParameterizedTest()
    @ValueSource(ints = {3, 5, 9, 13})
    void last_point_always_false(int position){
        RandomLineGenerator randomLineGenerator = RandomLineGenerator.from(position);
        boolean randomBoolean = randomLineGenerator.createRandomBoolean(position);
        Assertions.assertThat(randomBoolean).isFalse();
    }

    @DisplayName("한 라인의 point 는 무조건 하나")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 9, 13})
    void one_line_point_always_one(int position) {
        RandomLineGenerator randomLineGenerator = RandomLineGenerator.from(position);
        List<Boolean> points = IntStream.rangeClosed(1, position)
                .mapToObj(i -> randomLineGenerator.createRandomBoolean(i))
                .collect(Collectors.toList());
        int countOfPoint = (int) points.stream()
                .filter(point -> point == true)
                .count();
        Assertions.assertThat(countOfPoint).isEqualTo(1);
    }
}
