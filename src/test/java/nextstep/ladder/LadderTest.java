package nextstep.ladder;

import nextstep.ladder.participant.Participants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private static Participants participants;
    private static MiddleLadder randomPoint;

    @Test
    @BeforeAll
    static void setObject(){
        participants = Participants.of("a","b","c");
        randomPoint = new MiddleLadder() {
            @Override
            public boolean makeBoolean() {
                return true;
            }

            @Override
            public void resetLine() {

            }
        };
    }

    @Test
    @DisplayName("사다리 만들기 테스트 (높이 테스트)")
    void createTest1(){
        Ladder ladder = Ladder.of(participants, randomPoint, 5);
        assertThat(ladder.getDepth()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 만들기 테스트 (참가자 수 테스트)")
    void createTest2(){
        Ladder ladder = Ladder.of(participants, randomPoint, 5);
        assertThat(ladder.getParticipantsCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("사다리 만들기 테스트 (라인수 = 참가자수 - 1)")
    void createTest3() {
        Ladder ladder = Ladder.of(participants, randomPoint, 5);
        assertThat(ladder.getLineSize()).isEqualTo(2);
    }

}