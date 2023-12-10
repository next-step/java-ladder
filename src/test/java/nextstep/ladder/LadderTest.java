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
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertAll;

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

        assertAll(
                () -> assertThat(ladder.play(playerName)).hasSize(1),
                () -> assertThat(ladder.play(playerName)).contains(result)
        );
    }

    @Test
    void 사다리는_all을_입력하면_전체_참여자의_실행_결과를_출력한다() {
        Ladder ladder = new Ladder(
                List.of("pobi", "honux"),
                new Lines(List.of(
                        Line.from(List.of(new Point(false), new Point(false))),
                        Line.from(List.of(new Point(false), new Point(false)))
                )),
                List.of("꽝", "5000")
        );

        List<String> result = ladder.play("all");

        assertAll(
                () -> assertThat(result).hasSize(2),
                () -> assertThat(result).containsAll(List.of("꽝", "5000"))
        );
    }

    @Test
    void 사다리는_참여자가_아닌_이름으로_결과를_확인할_수_없다() {
        Ladder ladder = new Ladder(
                List.of("pobi", "honux"),
                new Lines(List.of(Line.from(List.of(new Point(false), new Point(false))))),
                List.of("꽝", "5000")
        );

        Throwable throwable = catchThrowable(() -> ladder.play("참가자아님"));

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자가 아닙니다.");
    }
}
