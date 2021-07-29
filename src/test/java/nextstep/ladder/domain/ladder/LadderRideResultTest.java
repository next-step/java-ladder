package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 위치 그룹 테스트")
class LadderRideResultTest {

    @DisplayName("사다리 위치 그룹은 사다리 위치 리스트를 가지고 생성한다")
    @Test
    void init() {
        List<LadderPosition> ladderPositions = Arrays.asList(LadderPosition.from(0), LadderPosition.from(1));
        assertThat(LadderRideResult.from(ladderPositions)).isInstanceOf(LadderRideResult.class);
    }

    @DisplayName("사다리 위치 그룹이 null 일 경우 예외를 발생 시킨다")
    @Test
    void initException() {
        assertThat(LadderRideResult.from(null)).isInstanceOf(LadderRideResult.class);
    }
}
