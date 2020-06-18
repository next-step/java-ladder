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


    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("사다리 셋팅 후 가로 라인이 겹치지 않는 테스트")
    void 가로라인_겹치지_않는_테스트(int inputLadderHeight) {
        Line line = new Line(inputLadderHeight);
        List<Boolean> oneLayerLadder = line.getOneLayerLadder();
        for (int i = 1; i < oneLayerLadder.size(); i++) {
            Boolean aBoolean = oneLayerLadder.get(i - 1);
            if (aBoolean) {
                assertThat(oneLayerLadder.get(i)).isFalse();
            }
        }
    }

}
