package laddergame.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndPointTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_null_name() {
        new EndPoint(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_empty_name() {
        new EndPoint("", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_long_name() {
        new EndPoint("abcdef", 0);
    }

    @Test
    public void constructor_for_valid_name() {
        String expected = "abcde";
        EndPoint participant = new EndPoint(expected, 0);
        assertEquals(expected, participant.getName());
    }
}