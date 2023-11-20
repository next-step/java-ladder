package ladder.domain;

import ladder.domain.Column;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ColumnTest {

    @Test
    @DisplayName("Line는 true, false 값을 가질 수 있다.")
    void createPoint(){
        assertThat(new Column(true)).isInstanceOf(Column.class);
    }

}
