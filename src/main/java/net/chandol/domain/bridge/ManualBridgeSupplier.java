package net.chandol.domain.bridge;

import net.chandol.value.Positive;

import java.util.List;

import static java.util.Arrays.asList;

public class ManualBridgeSupplier implements BridgesSupplier {
    private final List<Bridge> bridgeValues;

    public ManualBridgeSupplier(List<Bridge> bridgeValues) {
        this.bridgeValues = bridgeValues;
    }

    public ManualBridgeSupplier(Bridge... bridgeValues) {
        this.bridgeValues = asList(bridgeValues);
    }

    @Override
    public Bridges createBridges(Positive lineSize, Positive height) {
        return new Bridges(lineSize, height, bridgeValues);
    }
}
