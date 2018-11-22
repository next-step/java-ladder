package game.ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class LadderTest {

    @Test
    public void 만들기() {
        final UserInputs inputs = makeUserInputs();
        final Height height = new Height(3);

        Ladder ladder = new Ladder(inputs, new LadderLines(height, inputs.partipantsSize()));
    }

    private UserInputs makeUserInputs() {
        Participants participants = makePartipants();
        Expects expects = makeExpects();
        return new UserInputs(participants, expects);
    }

    private Participants makePartipants() {
        List<Participant> list = Arrays.asList(new Participant(new Name("a"), new Position(1)), new Participant(new Name("b"), new Position(2)));
        SortedSet<Participant> participantSet = new TreeSet<>(list);
        return new Participants(participantSet);
    }

    private Expects makeExpects() {
        List<Expect> expectList = Arrays.asList(new Expect("o"), new Expect("x"));
        return new Expects(expectList);
    }

}