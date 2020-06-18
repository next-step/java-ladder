package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 가로라인 클래스 테스트")
public class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("사다리 가로라인 생성 테스트")
    void initLine(int participantsCount) {
        Line line = new Line(participantsCount);
        List<Boolean> oneLayerLadder = line.getOneLayerLadder();
        assertThat(oneLayerLadder).hasSize(participantsCount);
    }

}
