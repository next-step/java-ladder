package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LinesTest {

    @DisplayName("List<Line> 생성 확인")
    @Test
    void getLines() {
        Lines lines = Lines.of(10);
        List<Line> newLines = lines.createLines(10);
        assertThat(newLines.size()).isEqualTo(9);
    }

    @Test
    void checkIfInputIsValid() {
        assertThatThrownBy(() -> Lines.of(-1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Lines.of(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
