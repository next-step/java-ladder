package nextstep.ladder.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SequentialRandomBridgesGenerator implements BridgesGenerator {

    private static final Integer MIN_NUMBERS_OF_PEOPLE = 2;

    @Override
    public List<Bridge> generateBridges(Integer numbersOfPeople) {
        validateNumbersOfPeople(numbersOfPeople);
        List<Bridge> bridges = new LinkedList<>();
        Bridge currentBridge = Bridge.of(ThreadLocalRandom.current().nextBoolean());
        for (int i = 0; i < numbersOfPeople - 1; i++) {
            bridges.add(currentBridge);
            currentBridge = currentBridge.next();
        }
        return bridges;
    }

    private void validateNumbersOfPeople(Integer numbersOfPeople) {
        if (numbersOfPeople < MIN_NUMBERS_OF_PEOPLE) {
            throw new IllegalArgumentException("사람은 최소 2명 이상이어야 합니다.");
        }
    }
}
