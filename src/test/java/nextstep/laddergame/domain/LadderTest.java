package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.*;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리 Ladder 객체를 생성한다.")
    @Test
    void create() {
        Integer position = 0;
        Lines lines = new Lines(List.of(TRUE, FALSE, TRUE));

        Ladder actual = new Ladder(position, lines);

        assertThat(actual).isEqualTo(new Ladder(0, new Lines(TRUE, FALSE, TRUE)));
    }

    @DisplayName("이전 사다리가 놓인 위치는 제외하고 사다리를 놓는다.")
    @Test
    void create_by_randomLadderLinesGenerator() {
        RandomLadderLinesGenerator randomLadderLinesGenerator = new RandomLadderLinesGenerator();
        Ladder actual = Ladder.create(Optional.of(new Ladder(0, new Lines(List.of(TRUE, FALSE, TRUE)))), 3, randomLadderLinesGenerator);

        assertThat(actual).extracting("position")
                .isEqualTo(1);
        assertThat(actual.isLineAlreadySetAt(0)).isFalse();
        assertThat(actual.isLineAlreadySetAt(2)).isFalse();
    }
}
