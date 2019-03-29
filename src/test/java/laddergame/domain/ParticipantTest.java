package laddergame.domain;

import org.junit.Test;

import static laddergame.ApplicationLauncher.ALL;

public class ParticipantTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_for_ALL() {
        new Participant(ALL, 0);
    }
}