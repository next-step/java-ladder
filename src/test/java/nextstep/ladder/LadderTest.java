package nextstep.ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private static Participants participants;
    private static RandomPoint randomPoint;

    @Test
    @BeforeAll
    static void setObject(){
        participants = Participants.of("a","b","c");
        randomPoint = new RandomPoint() {
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