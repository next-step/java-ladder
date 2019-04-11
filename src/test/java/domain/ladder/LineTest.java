package domain.ladder;

import org.junit.Test;
import domain.bridge.BridgeGenerator;
import domain.bridge.BridgeRandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void generate_line() {
        int userCount = 3;

        BridgeGenerator bridgeGenerator = new BridgeRandomGenerator();

        Line line = new Line(bridgeGenerator);
        line.generate(userCount);
        assertThat(line.size()).isEqualTo(userCount);
    }
}
