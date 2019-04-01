package laddergame.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static laddergame.ApplicationLauncher.ALL;
import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_wrong_named_participants() {
        new Participants(new String[]{ALL});
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_duplicated_participants1() {
        new Participants(new String[]{"a","a"});
    }

    @Test
    public void constructor_for_duplicated_participants2() {
        List<Participant> expected = Arrays.asList(
                new Participant("a", 0),
                new Participant("b", 1)
        );
        Participants actual = new Participants(new String[]{"a","a","b"});

        for(int i = 0; i < expected.size(); ++i) {
            assertThat(expected.get(i)).isEqualTo(actual.getEndPoint(i));
        }
    }
}