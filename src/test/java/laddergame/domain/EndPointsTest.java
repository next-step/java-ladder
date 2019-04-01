package laddergame.domain;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class EndPointsTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_none_participants() {
        new EndPoints(new String[]{""});
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_one_participant() {
        new EndPoints(new String[]{"a"});
    }

    @Test
    public void constructor_for_duplicated_participants1() {
        List<EndPoint> expected = Arrays.asList(
                new EndPoint("a", 0),
                new EndPoint("a", 1)
        );
        EndPoints actual = new EndPoints(new String[]{"a","a"});

        for(int i = 0; i < expected.size(); ++i) {
            assertThat(expected.get(i)).isEqualTo(actual.getEndPoint(i));
        }
    }

    @Test
    public void constructor_for_duplicated_participants2() {
        List<EndPoint> expected = Arrays.asList(
                new EndPoint("a", 0),
                new EndPoint("a", 1),
                new EndPoint("b", 2)
        );
        EndPoints actual = new EndPoints(new String[]{"a","a","b"});

        for(int i = 0; i < expected.size(); ++i) {
            assertThat(expected.get(i)).isEqualTo(actual.getEndPoint(i));
        }
    }

    @Test
    public void constructor_for_two_valid_participants() {
        List<EndPoint> expected = Arrays.asList(
            new EndPoint("a", 0),
            new EndPoint("b", 1)
        );
        EndPoints actual = new EndPoints(new String[]{"a","b"});

        for(int i = 0; i < expected.size(); ++i) {
            assertThat(expected.get(i)).isEqualTo( actual.getEndPoint(i));
        }
    }

    @Test
    public void constructor_for_three_valid_participants() {
        List<EndPoint> expected = Arrays.asList(
                new EndPoint("a", 0),
                new EndPoint("b", 1),
                new EndPoint("c", 2)
        );
        EndPoints actual = new EndPoints(new String[]{"a","b","c"});

        for(int i = 0; i < expected.size(); ++i) {
            assertThat(expected.get(i)).isEqualTo( actual.getEndPoint(i));
        }
    }
}