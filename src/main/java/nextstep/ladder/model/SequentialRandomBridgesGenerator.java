package nextstep.ladder.model;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SequentialRandomBridgesGenerator implements BridgesGenerator {

    @Override
    public List<Bridge> generateBridges(Integer numbersOfPeople) {
        List<Bridge> bridges = new LinkedList<>();
        Bridge currentBridge = Bridge.of(ThreadLocalRandom.current().nextBoolean());
        for (int i = 0; i < numbersOfPeople - 1; i++) {
            bridges.add(currentBridge);
            currentBridge = currentBridge.next();
        }
        return bridges;
    }
}
