package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinesFactoryTest {

    @Test
    @DisplayName("rowCount, colCount, LineGenerator, ListGenerator로 Lines를 생성한다")
    void create() {
        assertThat(LinesFactory.of(3, 3, new RandomLineGenerator(), new RandomBooleanListGenerator())).isInstanceOf(Lines.class);
    }
}