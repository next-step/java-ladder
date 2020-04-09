package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LadderPole {

    private final int polePosition;

    private LadderPole(int polePosition) {
        if (polePosition < 0) {
            throw new IllegalArgumentException("Ladder pole must be greater than zero.");
        }
        this.polePosition = polePosition;
    }

    public static LadderPole of(int polePosition) {
        return new LadderPole(polePosition);
    }

    public LadderPole move(final int movableBridgePosition) {
        if (polePosition == movableBridgePosition) {
            return LadderPole.of(polePosition + 1);
        }
        return LadderPole.of(polePosition - 1);
    }

    public LadderPole nextLadderPole(final List<LadderBridge> bridges) {
        return findMovableBridgeIndex(bridges)
                .map(this::move)
                .orElse(this);
    }

    private Optional<Integer> findMovableBridgeIndex(final List<LadderBridge> bridges) {
        List<Integer> bridgeIndexes = new ArrayList<>();

        if (polePosition != 0) {
            bridgeIndexes.add(polePosition - 1);
        }

        if (polePosition != bridges.size()) {
            bridgeIndexes.add(polePosition);
        }

        return bridgeIndexes.stream()
                .filter(i -> bridges.get(i) == LadderBridge.EXIST)
                .findAny();
    }

    public int toInt() {
        return polePosition;
    }
}
