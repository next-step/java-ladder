package nextstep.ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    void test(){
        String s = "C-2013-08-22-지게차D33SE-5-04하2549 경기04하2549 지게차주유(경유20";
        byte[] bTest = s.getBytes();
        assertThat(getMaxByteString(s,40)).isEqualTo(40);
        assertThat(bTest.length).isEqualTo(40);
    }
    public String getMaxByteString(String str, int maxLen)
    {
        StringBuilder sb = new StringBuilder();
        int curLen = 0;
        String curChar;

        for (int i = 0; i < str.length(); i++)
        {
            curChar = str.substring(i, i + 1);
            curLen += curChar.getBytes().length;
            if (curLen > maxLen)
                break;
            else
                sb.append(curChar);
        }
        return sb.toString();
    }
}