package nextstep.step2;

import nextstep.step2.domain.Line;
import nextstep.step2.domain.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

@DisplayName("사다리 가로라인 클래스 테스트")
public class LinesTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("사다리타기 참여자, 사다리 높이 입력받아서 참여자 x 사다리높이 만큼 셋팅되는지 테스트")
    void inputNamesAndLadderHeightTest(int input) {
        Lines lines = new Lines(input, input);
        List<Line> lineList = lines.getLines();
        assertThat(lineList).hasSize(input);

        lineList.forEach(line -> assertThat(line.getOneLayerLadder()).hasSize(input));
    }
}
