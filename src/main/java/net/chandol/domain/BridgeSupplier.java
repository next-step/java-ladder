package net.chandol.domain;

import net.chandol.value.Bridge;
import net.chandol.value.Positive;

import java.util.List;

public interface BridgeSupplier {
    List<Bridge> createBridges(Positive lineSize, Positive height);
}
