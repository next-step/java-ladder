package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.exception.LineConsecutivePointException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LineTest {

    @Test
    @DisplayName("[성공] 4 만큼의 라인을 생성한다.")
    void 라인_생성() {
        assertThat((Line.of(List.of(true, false, true, false)).get())).hasSize(4);
    }

    @ParameterizedTest(name = "[{index}] line.get().get({0}) is {1}")
    @CsvSource(value = {"0:true", "1:false", "2:true"}, delimiter = ':')
    @DisplayName("[성공] 가로 라인이 있거나 없는 라인을 생성한다.")
    void 라인_생성_가로_라인_유무(int index, boolean bool) {
        Line line = Line.of(List.of(true, false, true));
        assertThat(line.get().get(index)).isEqualTo(bool);
    }

    @Test
    @DisplayName("[실패] 라인의 좌표가 연속적으로 true 가 나오는 경우 LineConsecutivePointException 예외가 발생한다.")
    void 라인_생성_예외() {
        assertThatExceptionOfType(LineConsecutivePointException.class)
                .isThrownBy(() -> Line.of(List.of(true, true, false)))
                .withMessageContaining("하나의 라인에 연속적인 좌표는 가질 수 없습니다.");
    }

}
