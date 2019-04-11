package domain.ladder;

import domain.bridge.TestBridgeGenerator;
import org.junit.Test;
import domain.bridge.BridgeGenerator;
import domain.bridge.BridgeRandomGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private BridgeGenerator bridgeGenerator;

    @Test
    public void generate_line() {
        int userCount = 3;

        BridgeGenerator bridgeGenerator = new BridgeRandomGenerator();

        Line line = new Line(bridgeGenerator);
        line.generate(userCount);
        assertThat(line.size()).isEqualTo(userCount);
    }

    @Test
    public void generate_참가자1명_라인만들기() {
        BridgeGenerator bridgeGenerator = new BridgeRandomGenerator();
        Line line = new Line(bridgeGenerator);
        line.generate(1);
        assertThat(line.size()).isEqualTo(1);
    }

    @Test
    public void 다음_사다리위치_구하기() {
        BridgeGenerator bridgeGenerator = new TestBridgeGenerator();
        Line line = new Line(bridgeGenerator);
        line.generate(2);
        int current = 1;
        int next = line.next(current);
        assertThat(next).isEqualTo(0);
    }
}
