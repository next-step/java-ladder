package net.chandol.domain.bridge;

import net.chandol.value.Positive;

import java.util.List;

public class ManualBridgeSupplier implements BridgesSupplier {
    private final List<Bridge> bridgeValues;

    public ManualBridgeSupplier(List<Bridge> bridgeValues) {
        this.bridgeValues = bridgeValues;
    }

    @Override
    public Bridges createBridges(Positive lineSize, Positive height) {
        return new Bridges(lineSize, height, bridgeValues);
    }
}
