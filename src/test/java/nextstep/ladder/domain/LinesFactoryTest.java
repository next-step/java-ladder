package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesFactoryTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("rowCount, colCount, LineGenerator, ListGenerator로 Lines를 생성한다")
    void create() {
        assertThat(LinesFactory.of(3, new RandomBooleanListGenerator(3)))
                .isInstanceOf(Lines.class);
    }
}