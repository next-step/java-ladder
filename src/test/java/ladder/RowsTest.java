package ladder;

import ladder.model.Row;
import ladder.model.Rows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RowsTest {
    @DisplayName("Rows 객체 생성")
    @Test
    void createTest() {
        //given
        Row row = Row.create(5);

        //when
        Rows rows = Rows.create(3);

        //then
        assertThat(rows.getRows()).hasSize(3);
    }
}
