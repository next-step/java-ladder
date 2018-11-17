package game.ladder.domain;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    @Test
    public void 참여자_만들기() {
        final Name name = new Name("name");
        final Position position = new Position(2);
        Participant participant = new Participant(name, position);

        assertThat(participant.getName()).isEqualTo(name);
        assertThat(participant.getPosition()).isEqualTo(position);
    }

    @Test
    public void 참여자_동등성_확인() {
        final Name name = new Name("test");
        final Position position = new Position(1);

        final Participant participant1 = new Participant(name, position);
        final Participant participant2 = new Participant(name, position);

        assertThat(participant1).isEqualTo(participant2);
    }

    @Test
    public void 참여자_동등성_확인_이름_다를때() {
        final Position position = new Position(1);

        final Participant participant1 = new Participant(new Name("a"), position);
        final Participant participant2 = new Participant(new Name("b"), position);

        assertThat(participant1).isNotEqualTo(participant2);
    }

    @Test
    public void 참여자_동등성_확인_포지션_다를때() {
        final Name name = new Name("name");

        final Participant participant1 = new Participant(name, new Position(3));
        final Participant participant2 = new Participant(name, new Position(4));

        assertThat(participant1).isNotEqualTo(participant2);
    }

    @Test
    public void 참여자_정렬() {
        final List<Participant> testList = makeTestList();

        SortedSet<Participant> participants = new TreeSet<>(testList);

        assertThat(participants).containsSequence(testList.toArray(new Participant[]{}));
    }


    private List<Participant> makeTestList() {
        List<Participant> list = new ArrayList<>();
        final Position first = new Position(1);
        final Position second = new Position(2);
        final Position third = new Position(3);

        list.add(new Participant(new Name("1"), first));
        list.add(new Participant(new Name("2"), second));
        list.add(new Participant(new Name("3"), third));

        return list;
    }

}