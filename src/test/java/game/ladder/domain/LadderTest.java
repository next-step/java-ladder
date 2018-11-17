package game.ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderTest {

    @Test
    public void 만들기() {
        final LinesGenerator generator = new LinesGenerator(new Height(5));
        final Participants participants = new Participants(makeParticipants());
        Ladder ladder = new Ladder(generator, participants);
    }

    private SortedSet<Participant> makeParticipants() {
        return IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new Participant(new Name(String.valueOf(i)), new Position(i)))
                .collect(Collectors.toCollection(TreeSet::new));
    }
}