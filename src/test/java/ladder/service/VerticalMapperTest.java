package ladder.service;

import ladder.model.HorizontalLine;
import ladder.model.LineUnit;
import ladder.model.VerticalLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class VerticalMapperTest {

    @Test
    void shouldMapLine() {
        List<HorizontalLine> horizontalLine = List.of(new HorizontalLine(List.of(new LineUnit(), new LineUnit(), new LineUnit())));

        List<VerticalLine> verticalLines = VerticalMapper.map(horizontalLine,3);

        assertThat(verticalLines.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("추가하고자 하는 라인 행수와 유저 개수가 맞지 않을떄는 예외가 발생해야 합니다.")
    void shouldNotMapLine_whenDifferentNum() {
        List<HorizontalLine> horizontalLine = List.of(new HorizontalLine(List.of(new LineUnit(), new LineUnit(), new LineUnit())));

        assertThatThrownBy(() -> VerticalMapper.map(horizontalLine,2)).isInstanceOf(IllegalArgumentException.class);
    }

}
