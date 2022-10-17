package nextstep.ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("Line을 생성한 이후에 true만을 삽입하여 원하는 결과가 나오는지에 대한 테스트")
    public void connectBridgeTrueTest() {
        Line line = new Line(new ArrayList<>());
        List<Bridge> expectLine = new ArrayList<>();
        line.checkDecidingConnectBridge(() -> true);
        line.checkDecidingConnectBridge(() -> true);
        line.checkDecidingConnectBridge(() -> true);
        expectLine.add(new Bridge(false));
        expectLine.add(new Bridge(true));
        expectLine.add(new Bridge(false));
        assertThat(line.getLine()).isEqualTo(expectLine);
    }

    @Test
    @DisplayName("Line을 생성한 이후에 false값만 삽입하여 원하는 결과가 나오는지에 대한 테스트")
    public void connectBridgeFalseTest() {
        Line line = new Line(new ArrayList<>());
        List<Bridge> expectLine = new ArrayList<>();
        line.checkDecidingConnectBridge(() -> false);
        line.checkDecidingConnectBridge(() -> false);
        line.checkDecidingConnectBridge(() -> false);
        expectLine.add(new Bridge(false));
        expectLine.add(new Bridge(false));
        expectLine.add(new Bridge(false));
        assertThat(line.getLine()).isEqualTo(expectLine);
    }

}