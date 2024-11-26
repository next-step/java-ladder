package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.*;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리 Ladder 객체를 생성한다.")
    @Test
    void create() {
        int position = 2;
        Lines lines = new Lines(List.of(TRUE, FALSE, TRUE));

        Ladder actual = new Ladder(position, lines);

        assertThat(actual).isEqualTo(new Ladder(new Position(position), new Lines(TRUE, FALSE, TRUE)));
    }

}
