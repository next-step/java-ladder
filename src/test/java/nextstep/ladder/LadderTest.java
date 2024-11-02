package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    @DisplayName("사다리 전체 출력 확인")
    void check() {
        Ladder ladder = new Ladder(6, 3);
        System.out.println(ladder);
    }
}
