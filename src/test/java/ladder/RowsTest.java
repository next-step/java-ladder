package ladder;

import ladder.model.Height;
import ladder.model.Rows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RowsTest {
    @DisplayName("Rows 객체 생성")
    @Test
    void createTest() {
        //when
        Rows rows = Rows.create(4, new Height(5));

        //then
        assertThat(rows.getRows()).hasSize(5);
    }
}