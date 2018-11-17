package game.ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    private SortedSet<Participant> inputs;
    private Participants participants;

    @Before
    public void setup() {
        inputs = new TreeSet<>(Arrays.asList(
                new Participant(new Name("1"), new Position(1)), new Participant(new Name("2"), new Position(2))
            )
        );

        participants = new Participants(inputs);
    }

    @Test
    public void 만들기() {
        assertThat(participants.size()).isEqualTo(inputs.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 만들기_참여자_한명_일때() {
        inputs = new TreeSet<>(Arrays.asList(new Participant(new Name("1"), new Position(1))));

        new Participants(inputs);
    }
}