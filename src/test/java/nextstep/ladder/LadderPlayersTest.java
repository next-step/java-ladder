package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderPlayers;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Name;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.domain.LadderPlayers.MIN_COUNT_OF_PERSON;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderPlayersTest {

    @Test
    void 사다리_게임_참가자_2명_미만일_수_없다() {
        assertThatThrownBy(() -> new Ladder(new LadderPlayers(List.of(new Name("pobi"))), new Lines(List.of(Line.from(1)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 " + MIN_COUNT_OF_PERSON + "명 이상의 참가자가 있어야 합니다.");
    }

    @Test
    void 사다리_게임_참가자는_2명_이상의_참가자로_구성된다() {
        assertThatCode(() -> new LadderPlayers(List.of(new Name("pobi"), new Name("honux"))))
                .doesNotThrowAnyException();
    }
}
