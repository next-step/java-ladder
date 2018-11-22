package game.ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputsTest {

    @Test
    public void 만들기() {
        final Participants participants = makeThreeParticipants();
        final Expects expects = makeExpects();

        UserInputs userInputs = new UserInputs(participants, expects);

        assertThat(userInputs.partipantsSize()).isEqualTo(participants.size());
        assertThat(userInputs.expectsSize()).isEqualTo(expects.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 만들기_참여자와_기대결과_숫자_다를때() {
        final Participants participants = makeThreeParticipants();
        final Expects expects = new Expects(Arrays.asList(new Expect("a"), new Expect("b")));

        new UserInputs(participants, expects);
    }

    @Test
    public void 최종_결과들_가져오기_2() {
        final Participants participants = makeThreeParticipants();
        final Expects expects = makeExpects();
        final UserInputs userInputs = new UserInputs(participants, expects);
        final LadderLines ladderLines = new LadderLines(new Height(5), userInputs.partipantsSize());

        GameResults gameResults = userInputs.makeGameResults(new Name("a"), ladderLines);

        assertThat(gameResults.size()).isEqualTo(1);
    }

    @Test
    public void 최종_결과들_가져오기_이름이_all_일때2() {
        final Participants participants = makeThreeParticipants();
        final Expects expects = makeExpects();
        final UserInputs userInputs = new UserInputs(participants, expects);

        final LadderLines ladderLines = new LadderLines(new Height(5), userInputs.partipantsSize());

        GameResults gameResults = userInputs.makeGameResults(new Name("all"), ladderLines);

        assertThat(gameResults.size()).isEqualTo(3);
    }

    private Expects makeExpects() {
        List<Expect> list = Arrays.asList(new Expect("q"), new Expect("w"), new Expect("e"));
        return new Expects(list);
    }

    private Participants makeThreeParticipants() {
        List<Participant> list = Arrays.asList(
                new Participant(new Name("a"), new Position(0)),
                new Participant(new Name("b"), new Position(1)),
                new Participant(new Name("c"), new Position(2))
        );
        SortedSet<Participant> participantSet = new TreeSet<>(list);
        return new Participants(participantSet);
    }

}