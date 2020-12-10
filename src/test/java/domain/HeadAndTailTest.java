package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeadAndTailTest {
    private HeadAndTail headAndTail;

    @BeforeEach
    void setUp(){
        Participants participants = Participants.of("a,b,c,d,e");
        Rewards rewards = Rewards.of("1,2,3,4,5");
        headAndTail = HeadAndTail.init(participants, rewards);
    }

    @Test
    void getParticipantsTest() {
        assertThat(headAndTail.getParticipants().size()).isEqualTo(5);
    }

    @Test
    void getRewardsTest() {
        assertThat(headAndTail.getRewards().size()).isEqualTo(5);
    }
}
