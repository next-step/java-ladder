package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    void Line_creation_test() {
        int countOfParticipants = 5;
        Line line = Line.of(countOfParticipants);

        Point prev = line.getPoint(0);
        Point next = line.getPoint(1);

        assertThat(prev.getRight()).isEqualTo(next.getLeft());
    }

    @Test
    void Line_exception_test() {
        String input = "pobi";
        assertThatThrownBy(() ->
                Line.of(Participants.of(input))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Line_creation_with_participants() {
        Participants participants = Participants.of("pobi,honux,crong,jk");

        Line line = Line.of(participants);

        Point prev = line.getPoint(0);
        assertThat(prev.getLeft()).isFalse();

        for (int i = 1; i < participants.getSize(); ++i) {
            Point next = line.getPoint(i);
            assertThat(prev.getRight()).isEqualTo(next.getLeft());
            prev = next;
        }
        assertThat(prev.getRight()).isFalse();
    }
}
