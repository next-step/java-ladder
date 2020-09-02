package nextstep.mission.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderTest {

    @Test
    void make() {
        assertThatCode(() -> Ladder.make(
                new Participants(Arrays.asList(
                        new Participant("user1"),
                        new Participant("user2"),
                        new Participant("user3"),
                        new Participant("user4")
                )), 5
        )).doesNotThrowAnyException();
    }
}
