package laddergame.domain.ladder;

import java.util.Random;

public class RandomConnectGenerator implements BridgeConnectGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public boolean generateConnectionState() {
        return RANDOM.nextBoolean();
    }
}
