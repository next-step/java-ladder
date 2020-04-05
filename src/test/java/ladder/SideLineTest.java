package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SideLineTest {

    @Test
    @DisplayName("옆줄 생성 테스트")
    void createSideLineTest() {
        SideLine sideLine = new SideLine(new Point(0, 0), new Point(1, 0));
    }
}
