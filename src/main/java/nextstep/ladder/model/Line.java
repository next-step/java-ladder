package nextstep.ladder.model;

import java.util.List;

public class Line {

    private static final Integer MIN_NUMBERS_OF_PEOPLE = 2;

    private final List<Bridge> bridges;
    
    public Line(Integer numbersOfPeople, List<Bridge> bridges) {
        validateLine(numbersOfPeople, bridges);
        this.bridges = bridges;
    }

    private void validateLine(Integer numbersOfPeople, List<Bridge> bridges) {
        validateBridgeCount(numbersOfPeople, bridges);
        validateContinuousTrueBridge(bridges);
        validateNumbersOfPeople(numbersOfPeople);
    }

    private void validateBridgeCount(Integer numbersOfPeople, List<Bridge> bridges) {
        if (bridges.size() != numbersOfPeople - 1) {
            throw new IllegalArgumentException("다리의 개수는 사람의 수보다 1 작아야합니다");
        }
    }

    private void validateContinuousTrueBridge(List<Bridge> bridges) {
        bridges.stream()
                .reduce((prevBridge, currentBridge) -> {
                    prevBridge.compareToNextBridge(currentBridge);
                    return currentBridge;
                });
    }

    private void validateNumbersOfPeople(Integer numbersOfPeople) {
        if (numbersOfPeople < MIN_NUMBERS_OF_PEOPLE) {
            throw new IllegalArgumentException("사람은 최소 2명 이상이어야 합니다.");
        }
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
