package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgesTest {

    @Test
    void apply() {
        Participants participants = Participants.createParticipants(List.of("a", "b", "c"));
        Bridges bridges = new Bridges(List.of(true, true, false));

        // abc -> bac -> bca
        bridges.apply(participants);

        assertThat(participants.getParticipants())
                .containsExactly(new Participant("b"), new Participant("c"), new Participant("a"));
    }

}
