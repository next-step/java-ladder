package domain;

import org.junit.Test;

public class ParticipantTest {

    @Test(expected = IllegalArgumentException.class)
    public void 이름_5자_넘으면_Exception() {
        new Participant("123456");
    }
}