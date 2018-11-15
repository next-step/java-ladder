package game.ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    @Test
    public void 참여자_만들기() {
        final String name = "name";
        final int value = 2;
        Participant participant = new Participant(name, new Position(value));

        assertThat(participant.getName()).isEqualTo(name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 참여자_만들기_공백_이름() {
        final String name = "";
        new Participant(name, new Position(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 참여자_만들기_null_이름() {
        final String name = null;
        new Participant(name, new Position(3));
    }

    @Test
    public void 참여자_동등성_확인() {
        final String name = "test";
        final Position position = new Position(1);

        final Participant participant1 = new Participant(name, position);
        final Participant participant2 = new Participant(name, position);

        assertThat(participant1).isEqualTo(participant2);
    }

    @Test
    public void 참여자_동등성_확인_이름_다를때() {
        final Position position = new Position(1);

        final Participant participant1 = new Participant("a", position);
        final Participant participant2 = new Participant("b", position);

        assertThat(participant1).isNotEqualTo(participant2);
    }

    @Test
    public void 참여자_동등성_확인_포지션_다를때() {
        final String name = "name";

        final Participant participant1 = new Participant(name, new Position(3));
        final Participant participant2 = new Participant(name, new Position(4));

        assertThat(participant1).isNotEqualTo(participant2);
    }
}