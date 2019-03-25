package laddergame.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParticipantTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_null_name() {
        new Participant(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_empty_name() {
        new Participant("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_long_name() {
        new Participant("abcdef");
    }

    @Test
    public void constructor_for_valid_name() {
        String expected = "abcde";
        Participant participant = new Participant(expected);
        assertEquals(expected, participant.getName());
    }
}