package model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {
    @Test
    public void getName_5자() {
        Participant participant = new Participant("bbibb");
        assertThat(participant.getName()).isEqualTo("bbibb");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getName_5자초과() {
        Participant participant = new Participant("bbibbb");
    }
}