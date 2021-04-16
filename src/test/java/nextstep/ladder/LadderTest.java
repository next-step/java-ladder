package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    @DisplayName(value = "사다리 생성")
    void init() {
        int sizeOfPerson = 2;
        int ladderHeight = 2;
        System.out.println(Ladder.of(sizeOfPerson, ladderHeight));
    }
}
