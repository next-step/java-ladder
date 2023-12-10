package nextstep.ladder.model;

import java.util.List;

public class Line {

    private final List<Bridge> bridges;
    
    public Line(Integer numbersOfPeople, List<Bridge> bridges) {
        validateLine(numbersOfPeople, bridges);
        this.bridges = bridges;
    }

    private void validateLine(Integer numbersOfPeople, List<Bridge> bridges) {
        validateBridgeCount(numbersOfPeople, bridges);
        validateContinuousTrueBridge(bridges);
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
}
