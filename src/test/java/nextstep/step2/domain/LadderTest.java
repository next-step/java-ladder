package nextstep.step2.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void 참여자와_사다리높이로_Lines_객체를_생성한다() {
        final var participants = defaultParticipants();

        final var lines = new Ladder(participants, 5);

        assertThat(lines.size()).isEqualTo(5);
    }

    private Participants defaultParticipants() {
        final var participant1 = new Participant("a");
        final var participant2 = new Participant("b");

        return new Participants(List.of(participant1, participant2));
    }

    @ParameterizedTest
    @CsvSource(value = {"a,0", "b,1", "c,2"})
    void 사다리게임_후_참여자의_위치를_구한다(String name, int expected) {
        final var ladder = createDefaultLadder();

        final var actual = ladder.move(name);

        assertThat(actual).isEqualTo(expected);
    }

    static Ladder createDefaultLadder() {
        final var participantList = List.of(
                new Participant("a"), new Participant("b"), new Participant("c")
        );

        final var lines = List.of(
                new Line(true, false, false), new Line(true, false, false)
        );

        return new Ladder(new Participants(participantList), lines);
    }
}
