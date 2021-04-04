package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    @DisplayName("라인들 생성")
    void createLines() {
        Lines lines = new Lines();
        assertThat(lines).isEqualTo(new Lines());
    }
}
