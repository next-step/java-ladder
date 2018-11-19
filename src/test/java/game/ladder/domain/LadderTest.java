package game.ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 만들기() {
        final LinesGenerator generator = new LinesGenerator(new Height(5));
        final Participants participants = new Participants(makeParticipants());
        final Expects expects = new Expects(Arrays.asList(new Expect("a"), new Expect("b"), new Expect("c")));

        Ladder ladder = new Ladder(generator, participants, expects);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 만들기_참여자와_기대결과_숫자_다를때() {
        final LinesGenerator generator = new LinesGenerator(new Height(5));
        final Participants participants = new Participants(makeParticipants());
        final Expects expects = new Expects(Arrays.asList(new Expect("a"), new Expect("b")));

        new Ladder(generator, participants, expects);
    }

    @Test
    public void 최종_결과들_가져오기() {
        final LinesGenerator generator = new LinesGenerator(new Height(5));
        final Participants participants = new Participants(makeParticipants());
        final Expects expects = new Expects(Arrays.asList(new Expect("a"), new Expect("b"), new Expect("c")));

        Ladder ladder = new Ladder(generator, participants, expects);

        GameResults gameResults = ladder.makeGameResults(new Name("1"));

        assertThat(gameResults.size()).isEqualTo(1);
    }

    @Test
    public void 최종_결과들_가져오기_이름이_all_일때() {
        final LinesGenerator generator = new LinesGenerator(new Height(5));
        final Participants participants = new Participants(makeParticipants());
        final Expects expects = new Expects(Arrays.asList(new Expect("a"), new Expect("b"), new Expect("c")));

        Ladder ladder = new Ladder(generator, participants, expects);

        GameResults gameResults = ladder.makeGameResults(new Name("all"));

        assertThat(gameResults.size()).isEqualTo(3);
    }

    private SortedSet<Participant> makeParticipants() {
        return IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new Participant(new Name(String.valueOf(i)), new Position(i)))
                .collect(Collectors.toCollection(TreeSet::new));
    }
}