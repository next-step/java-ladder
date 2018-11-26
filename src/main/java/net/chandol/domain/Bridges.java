package net.chandol.domain;

import net.chandol.support.FluentUtil;
import net.chandol.value.Bridge;
import net.chandol.value.Positive;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

public class Bridges {
    private final Positive lineSize;
    private final Positive height;
    private List<Bridge> values;

    public Bridges(Positive lineSize, Positive height, List<Bridge> inputBridgeValues) {
        this.lineSize = lineSize;
        this.height = height;
        this.values = new ArrayList<>();
        this.setBridges(inputBridgeValues);
    }

    private void setBridges(List<Bridge> inputBridgeValues) {
        inputBridgeValues.stream().forEach(this::addBridge);
    }

    private void addBridge(Bridge bridge) {
        validateBridgeValue(bridge);
        values.add(bridge);
    }

    private void validateBridgeValue(Bridge bridge) {
        if (bridge.getLeftLineNumber().value() >= lineSize.value() || bridge.getRow().value() >= height.value()) {
            throw new IllegalArgumentException("라인 및 높이가 맞지 않음");
        }

        if (values.stream().anyMatch(bridge::equals)) {
            throw new IllegalArgumentException("동일한 브릿지는 추가할 수 없음");
        }


        Bridge leftSiblingBridge = bridge.leftSiblingBridge();
        if (nonNull(leftSiblingBridge) && values.stream().anyMatch(leftSiblingBridge::equals)) {
            throw new IllegalArgumentException("브릿지는 연속되어선 안됨");
        }

        Bridge rightSiblingBridge = bridge.rightSiblingBridge();
        if (values.stream().anyMatch(rightSiblingBridge::equals)) {
            throw new IllegalArgumentException("브릿지는 연속되어선 안됨");
        }
    }

    public boolean hasBridge(Positive leftHandLine, Positive row) {
        return values.stream().anyMatch(b -> b.getLeftLineNumber().equals(leftHandLine) && b.getRow().equals(row));
    }
}
