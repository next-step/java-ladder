package nextstep.ladder2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NxLine {
    private final List<NxBridge> bridges;

    public NxLine(List<Boolean> booleans) {
        for (int i = 0; i < booleans.size() - 1; i++) {
            isAdjacentTrueValue(booleans.get(i), booleans.get(i + 1));
        }
        bridges = new ArrayList<>(booleans.size());
        for (int i = 0; i < booleans.size(); i++) {
            bridges.add(new NxBridge(i, booleans.get(i)));
        }
    }

    public NxBridge getBridgeByPoint(int pointIndex) {
        if (bridges.size() == pointIndex) {
            return getBridge(pointIndex - 1);
        }
        if (bridges.get(pointIndex).isEnabled()) {
            return getBridge(pointIndex);
        }
        return getBridge(pointIndex - 1);
    }

    private NxBridge getBridge(int index) {
        if (index < 0) {
            return bridges.get(0);
        }
        return bridges.get(index);
    }

    private static void isAdjacentTrueValue(boolean prev, boolean next) {
        if (prev && next) {
            throw new IllegalArgumentException("한 Line에 Bridge를 인접하여 생성할 수 없습니다.");
        }
    }

    public List<Boolean> getBridgeValues() {
        return bridges.stream()
                .map(NxBridge::isEnabled)
                .collect(Collectors.toList());
    }
}
