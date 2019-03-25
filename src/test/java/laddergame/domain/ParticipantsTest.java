package laddergame.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ParticipantsTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_none_participants() {
        new Participants("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_one_participant() {
        new Participants("a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_same_participants() {
        new Participants("a,a");
    }

    @Test
    public void constructor_for_valid_participants() {
        Set<Participant> expected = new HashSet<>(Arrays.asList(new Participant("a"), new Participant("b")));
        Participants actual = new Participants("a,b");

        assertEquals(expected, actual.getParticipants());
    }
}