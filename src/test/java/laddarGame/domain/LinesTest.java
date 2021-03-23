package laddarGame.domain;

import laddarGame.dto.LineDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinesTest {

    @DisplayName("입력된 높이 만큼 사다리 게임을 생성한다.")
    @Test
    void createLadder() {
        Lines lines = new Lines(3, 4);

        assertEquals(4, lines.linesDto().size());
    }

    @DisplayName("Dto를 생성한다.")
    @Test
    void createDto() {
        Lines lines = new Lines(createLines());

        List<LineDto> lineDtos = lines.linesDto();

        assertEquals(new LineDto(true, false, true, false), lineDtos.get(0));
    }

    List<Line> createLines() {
        return Arrays.asList(createLine(true, false, true, false)
                , createLine(false, true, false, true)
                , createLine(true, false, true, false));
    }

    Line createLine(boolean first, boolean second, boolean third, boolean fourth) {
        return new Line(List.of(first, second, third, fourth));
    }

}
