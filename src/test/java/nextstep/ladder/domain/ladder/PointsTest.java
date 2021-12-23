package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {

    @Test
    @DisplayName("인원 수만큼 해당 지점에 대한 사다리 계단 존재 유무를 생성한다")
    void shouldCreate() {
        List<Boolean> values = Arrays.asList(true, false, true);
        Points points = Points.of(3, numberOfParticipants -> values);

        assertThat(points).isEqualTo(Points.from(values));
    }
}