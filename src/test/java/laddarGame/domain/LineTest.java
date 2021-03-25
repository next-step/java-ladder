package laddarGame.domain;

import laddarGame.dto.LineDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    @DisplayName("가로라인은 중복될 수 없다.")
    @Test
    void isDuplicateHorizontal() {
        assertThrows(IllegalArgumentException.class,
                () -> new Line(List.of(true, true, false)));
    }

    @DisplayName("DTO 를 반환 한다.")
    @Test
    void createDto() {
        Line line = new Line(List.of(true, false, false));

        LineDto lineDto = line.lineDto();

        assertEquals(new LineDto(List.of(Point.of(true), Point.of(false), Point.of(false))), lineDto);
    }

}