package nextstep.ladder.domain.ladder;

import nextstep.ladder.util.RandomConnectStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리의 높이, 참여 인원 수, 연결 전략을 입력하면 사다리가 생성된다.")
    @Test
    void createLadderTest() {
        Ladder ladder = Ladder.from(5, 5, new RandomConnectStrategy());
        System.out.println(ladder);
    }
}
