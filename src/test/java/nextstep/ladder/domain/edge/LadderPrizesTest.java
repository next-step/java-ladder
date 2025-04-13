package nextstep.ladder.domain.edge;

import nextstep.ladder.domain.prize.LadderPrize;
import nextstep.ladder.domain.prize.LadderPrizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderPrizesTest {

    @DisplayName("LadderResults 인스턴스 생성")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new LadderPrizes(List.of(new LadderPrize("1000"))));
    }
}
