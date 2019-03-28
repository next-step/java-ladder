package laddergame.domain;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class EndPointsTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_none_participants() {
        new EndPoints(new String[]{""});
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_one_participant() {
        new EndPoints(new String[]{"a"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_duplicated_participants1() {
        new EndPoints(new String[]{"a","a"});
    }

    @Test
    public void constructor_for_duplicated_participants2() {
        List<EndPoint> expected = Arrays.asList(
                new EndPoint("a", 0),
                new EndPoint("b", 1)
        );
        EndPoints actual = new EndPoints(new String[]{"a","a","b"});

        for(int i = 0; i < expected.size(); ++i) {
            assertEquals(expected.get(i), actual.getEndPoint(i));
        }
    }


    @Test
    public void constructor_for_valid_participants() {
        List<EndPoint> expected = Arrays.asList(
            new EndPoint("a", 0),
            new EndPoint("b", 1)
        );
        EndPoints actual = new EndPoints(new String[]{"a","b"});

        for(int i = 0; i < expected.size(); ++i) {
            assertEquals(expected.get(i), actual.getEndPoint(i));
        }
    }
}