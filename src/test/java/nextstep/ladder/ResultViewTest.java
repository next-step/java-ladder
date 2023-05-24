package nextstep.ladder;

import nextstep.ladder.domain.ResultView;
import nextstep.ladder.dto.PointDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultViewTest {
    @Test
    void 오른쪽_라인_출력_테스트() {
        ResultView resultView = new ResultView();
        PointDto true_point = new PointDto(false, true);
        PointDto false_point = new PointDto(false, false);
        assertThat(resultView.getLine(true_point)).isEqualTo("_____");
        assertThat(resultView.getLine(false_point)).isEqualTo("     ");
    }
}
