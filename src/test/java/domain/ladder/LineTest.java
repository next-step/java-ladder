package domain.ladder;

import domain.bridge.BridgeGenerator;
import domain.bridge.BridgeRandomGenerator;
import domain.bridge.TestBridgeGenerator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private int limitValue = 3;

    @Test
    public void generate_line() {
        //given
        int userCount = 3;
        BridgeGenerator bridgeGenerator = new BridgeRandomGenerator(limitValue);

        //when
        Line line = new Line(bridgeGenerator);
        line.generate(userCount);

        //then
        assertThat(line.size()).isEqualTo(userCount);
    }

    @Test
    public void generate_참가자1명_라인만들기() {
        //given
        BridgeGenerator bridgeGenerator = new BridgeRandomGenerator(limitValue);
        Line line = new Line(bridgeGenerator);

        //when
        line.generate(1);

        //then
        assertThat(line.size()).isEqualTo(1);
    }

    @Test
    public void 다음_사다리위치_구하기() {
        //given
        BridgeGenerator bridgeGenerator = new TestBridgeGenerator();
        Line line = new Line(bridgeGenerator);

        //when
        line.generate(2);
        int current = 1;
        int next = line.next(current);

        //then
        assertThat(next).isEqualTo(0);
    }
}