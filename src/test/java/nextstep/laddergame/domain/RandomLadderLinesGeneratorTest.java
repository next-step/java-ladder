package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class RandomLadderLinesGeneratorTest {
    @DisplayName("이전 사다리가 놓인 위치는 제외하고 사다리 라인을 랜덤으로 놓는다.")
    @Test
    void generate() {
        Ladder given = new Ladder(0, new Lines(List.of(TRUE, FALSE, TRUE)));
        RandomLadderLinesGenerator ladderLinesGenerator = new RandomLadderLinesGenerator();

        Lines actual = ladderLinesGenerator.generate(Optional.of(given), 3);

        assertThat(actual.isAlreadySetAt(0)).isFalse();
        assertThat(actual.isAlreadySetAt(2)).isFalse();
    }
}