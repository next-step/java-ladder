package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTypeTest {

    LineTypeDTO verticalLineTypeDTO;
    LineTypeDTO horizontalLineTypeDTO;
    LineTypeDTO blankLineTypeDTO;

    @BeforeEach
    void setUp() {
        verticalLineTypeDTO = new LineTypeDTO(0, new HalfPossibilityStrategy(), true);
        horizontalLineTypeDTO = new LineTypeDTO(1, new OnePossibilityStrategy(), false);
        blankLineTypeDTO = new LineTypeDTO(1, new OnePossibilityStrategy(), true);
    }

    @Test
    void makeVerticalTypeTest() {
        LineType linetype = LineType.makeType(verticalLineTypeDTO);
        assertThat(LineType.VERTICAL.getLine()).isEqualTo(linetype.getLine());
    }

    @Test
    void getBlankTypeTest() {
        LineType linetype = LineType.makeType(blankLineTypeDTO);
        assertThat(LineType.BLANK.getLine()).isEqualTo(linetype.getLine());
    }

    @Test
    void getHorizontalTypeTest() {
        LineType linetype = LineType.makeType(horizontalLineTypeDTO);
        assertThat(LineType.HORIZONTAL.getLine()).isEqualTo(linetype.getLine());
    }
}
