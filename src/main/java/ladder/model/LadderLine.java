package ladder.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLine {

    private final List<LadderBridge> bridges;

    private LadderLine(final List<LadderBridge> bridges) {
        validate(bridges);
        this.bridges = Collections.unmodifiableList(bridges);
    }

    public static LadderLine newInstance(LadderBridge... bridges) {
        return new LadderLine(Arrays.asList(bridges));
    }

    // TODO: 2020-04-06 겹치는 구간이 없는지 validation 추가
    private void validate(final List<LadderBridge> bridges) {
        if (Objects.isNull(bridges) || bridges.isEmpty()) {
            throw new IllegalArgumentException("Ladder Bridge must be greater than zero.");
        }
    }

    public static LadderLine newInstance(final int poleCount) {
        List<LadderBridge> bridges = Stream.iterate(
                LadderBridge.randomBridge(),
                LadderBridge::makeRandomBridgeByPreBridge)
                .limit(poleCount - 1)
                .collect(Collectors.toList());

        return new LadderLine(bridges);
    }

    public LadderPoles getInitLadderPoles() {
        List<LadderPole> poles = IntStream.rangeClosed(0, bridges.size())
                .mapToObj(LadderPole::of)
                .collect(Collectors.toList());
        return LadderPoles.newInstance(poles);
    }

    public LadderPoles proceed(LadderPoles ladderPoles) {
        List<LadderPole> nextLadderPoles = ladderPoles.getLadderPoles()
                .stream()
                .map(ladderPole -> nextLadderPole(ladderPole.toInt()))
                .collect(Collectors.toList());

        return LadderPoles.newInstance(nextLadderPoles);
    }

    private LadderPole nextLadderPole(final int polePosition) {
        return getNearLadderBridgeIndex(polePosition).stream()
                .filter(i -> bridges.get(i) == LadderBridge.EXIST)
                .findAny()
                .map(LadderPole::of)
                .orElse(LadderPole.of(polePosition));
    }

    private List<Integer> getNearLadderBridgeIndex(final int polePosition) {
        List<Integer> bridgeIndexes = new ArrayList<>();

        if (polePosition != 0) {
            bridgeIndexes.add(polePosition - 1);
        }

        if (polePosition != bridges.size()) {
            bridgeIndexes.add(polePosition);
        }

        return bridgeIndexes;
    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }
}
