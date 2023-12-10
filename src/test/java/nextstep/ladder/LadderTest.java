package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    void 사다리는_최소_1이상의_높이를_가져야_한다() {
        assertThatThrownBy(() -> Ladder.of(List.of("pobi", "honux"), new Lines(List.of()), List.of("꽝", "5000")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 높이는 최소 1이상이어야 합니다.");
    }

    @Test
    void 사다리의_플레이어_수와_결과_수는_동일해야_한다() {
        assertThatThrownBy(() -> Ladder.of(
                        List.of("pobi", "honux"),
                        new Lines(List.of(
                                Line.from(List.of(new Point(false), new Point(false))),
                                Line.from(List.of(new Point(false), new Point(false)))
                        ))
                        , List.of("꽝")
                )
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어와 결과의 수는 동일해야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:꽝", "honux:5000"}, delimiter = ':')
    void 사다리는_이름을_받아_결과를_반환할_수_있다(String playerName, String result) {
        Ladder ladder = new Ladder(
                List.of("pobi", "honux"),
                new Lines(List.of(
                        Line.from(List.of(new Point(false), new Point(false))),
                        Line.from(List.of(new Point(false), new Point(false)))
                )),
                List.of("꽝", "5000")
        );

        assertThat(ladder.play(playerName)).isEqualTo(result);
    }
}
