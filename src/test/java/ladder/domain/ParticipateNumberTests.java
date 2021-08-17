package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipateNumberTests {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        ParticipateNumber participateNumber = ParticipateNumber.of(2);

        assertThat(participateNumber).isEqualTo(ParticipateNumber.of(2));
    }
}
