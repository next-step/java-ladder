package nextstep.ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    private static final int START_LOCATION = 1;
    private static final int LEFT_EXPECT_LOCATION = 0;
    private static final int RIGHT_EXPECT_LOCATION = 2;
    private static final int PEOPLE_COUNT = 3;

    @Test
    @DisplayName("Line을 생성한 이후에 true만을 삽입하여 원하는 결과가 나오는지에 대한 테스트")
    public void connectBridgeTrueTest() {
        Line line = new Line(new ArrayList<>());
        List<Point> expectLine = new ArrayList<>();
        line.checkDecidingConnectBridge(() -> true, PEOPLE_COUNT);
        line.checkDecidingConnectBridge(() -> true, PEOPLE_COUNT);
        line.checkDecidingConnectBridge(() -> true, PEOPLE_COUNT);
        Bridge firstBridge = Bridge.first(() -> true);
        expectLine.add(new Point(0, firstBridge));
        Bridge secondBridge = firstBridge.next(() -> true);
        expectLine.add(new Point(1, secondBridge));
        Bridge thirdBridge = secondBridge.last();
        expectLine.add(new Point(2, thirdBridge));
        assertThat(line.getLine()).isEqualTo(expectLine);
    }

    @Test
    @DisplayName("Line을 생성한 이후에 false값만 삽입하여 원하는 결과가 나오는지에 대한 테스트")
    public void connectBridgeFalseTest() {
        Line line = new Line(new ArrayList<>());
        List<Point> expectLine = new ArrayList<>();
        line.checkDecidingConnectBridge(() -> false, PEOPLE_COUNT);
        line.checkDecidingConnectBridge(() -> false, PEOPLE_COUNT);
        line.checkDecidingConnectBridge(() -> false, PEOPLE_COUNT);
        Bridge firstBridge = Bridge.first(() -> false);
        expectLine.add(new Point(0, firstBridge));
        Bridge secondBridge = firstBridge.next(() -> false);
        expectLine.add(new Point(1, secondBridge));
        Bridge thirdBridge = secondBridge.last();
        expectLine.add(new Point(2, thirdBridge));
        assertThat(line.getLine()).isEqualTo(expectLine);
    }

    @Test
    @DisplayName("Line을 생성한 이후에 move메소드가 왼쪽으로 정상적으로 작동 되는지에 대한 테스트")
    public void lineLeftMoveTest() {
        Line line = new Line(new ArrayList<>());
        line.checkDecidingConnectBridge(() -> true, PEOPLE_COUNT);
        line.checkDecidingConnectBridge(() -> false, PEOPLE_COUNT);
        line.checkDecidingConnectBridge(() -> false, PEOPLE_COUNT);
        assertThat(line.move(START_LOCATION)).isEqualTo(LEFT_EXPECT_LOCATION);
    }

    @Test
    @DisplayName("Line을 생성한 이후에 move메소드가 오른쪽으로 정상적으로 작동 되는지에 대한 테스트")
    public void lineRightMoveTest() {
        Line line = new Line(new ArrayList<>());
        line.checkDecidingConnectBridge(() -> false, PEOPLE_COUNT);
        line.checkDecidingConnectBridge(() -> true, PEOPLE_COUNT);
        line.checkDecidingConnectBridge(() -> false, PEOPLE_COUNT);
        assertThat(line.move(START_LOCATION)).isEqualTo(RIGHT_EXPECT_LOCATION);
    }

}