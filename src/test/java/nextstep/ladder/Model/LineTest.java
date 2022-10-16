package nextstep.ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("Line을 생성한 이후에 다리를 연결 잘하는지에 대한 테스트")
    public void connectBridgeTest(){
        Line line = new Line(new ArrayList<>());
        List<Boolean> expectLine = new ArrayList<>();
        line.checkThisPointIsAbleConnectAndExecuteConnect(()-> true);
        line.checkThisPointIsAbleConnectAndExecuteConnect(()-> true);
        expectLine.add(false);
        expectLine.add(true);
        assertThat(line.getLine()).isEqualTo(expectLine);
    }
}