package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-26 12:23
 */
public class ParticipantTest {
    @Test
    void 생성() {
        Participant participant = new Participant(new ArrayList<>());
        assertThat(participant).isEqualTo(new Participant(new ArrayList<>()));
    }

    @Test
    void 참여자_카운트() {
        Participant participant = new Participant(Arrays.asList("kim", "lee", "park"));
        assertThat(participant.numberOfParticipants()).isEqualTo(3);
    }
}
