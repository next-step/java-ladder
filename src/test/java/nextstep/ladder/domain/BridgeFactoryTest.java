package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class BridgeFactoryTest {

    @Test
    void createBridgeOfWidth() {
        int width = 100;
        List<Boolean> bridges = BridgeFactory.createBridgeOfWidth(width);

        for (int index = 1; index < width; index++) {
            boolean previousBridge = bridges.get(index - 1);
            boolean currentBridge = bridges.get(index);
            if (previousBridge && currentBridge) {
                fail();
            }
        }

        boolean lastBridge = bridges.get(bridges.size() - 1);
        if (lastBridge) {
            fail();
        }
    }
}
