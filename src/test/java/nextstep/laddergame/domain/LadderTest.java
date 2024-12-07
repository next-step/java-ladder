package nextstep.laddergame.domain;

import nextstep.laddergame.service.PlayResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.assertj.core.api.InstanceOfAssertFactories.MAP;

class LadderTest {
    @DisplayName("사다리 Ladder 객체를 생성한다.")
    @Test
    void create() {
        Line firstLine = new Line(List.of(TRUE, FALSE, FALSE));
        Line secondLine = new Line(List.of(TRUE, FALSE, FALSE));
        Line thirdLine = new Line(List.of(FALSE, TRUE, FALSE));

        Ladder actual = new Ladder(List.of(firstLine, secondLine, thirdLine));

        assertThat(actual).extracting("lines", as(LIST))
                .contains(new Line(List.of(TRUE, FALSE, FALSE)),
                        new Line(List.of(TRUE, FALSE, FALSE)),
                        new Line(List.of(FALSE, TRUE, FALSE)));
    }

    @DisplayName("사람 수만큼 사다리 실행하여 결과를 반환한다.")
    @Test
    void play() {
        Ladder given = new Ladder(List.of(
                new Line(List.of(TRUE, FALSE, FALSE)),
                new Line(List.of(TRUE, FALSE, FALSE)),
                new Line(List.of(FALSE, TRUE, FALSE))));

        PlayResult actual = given.play(3);

        assertThat(actual).extracting("playResult", as(MAP))
                .contains(entry(0, 0), entry(1, 2), entry(2, 1));
    }
}
