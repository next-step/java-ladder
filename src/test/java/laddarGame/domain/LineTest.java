package laddarGame.domain;

import laddarGame.dto.LineDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    @DisplayName("가로라인은 중복될 수 없다.")
    @Test
    void isDuplicateHorizontal() {
        assertThrows(IllegalArgumentException.class,
                () -> new Line(Arrays.asList(true, true, false)));
    }

    @DisplayName("DTO 를 반환 한다.")
    @Test
    void createDto() {
        Line line = new Line(Arrays.asList(true, false, false));

        LineDto lineDto = line.lineDto();

        assertEquals(new LineDto(Arrays.asList(true, false, false)), lineDto);
    }

}