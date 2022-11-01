package ladder.strategy;

import ladder.domain.BridgeLine;
import ladder.domain.BridgeLines;
import ladder.domain.LadderHeight;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeLinesRandomStrategy implements BridgeLinesStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public BridgeLines create(final int amount, final LadderHeight height) {
        List<BridgeLine> bridgeLines = new ArrayList<>() {{
            add(createBridgeLine(height));
        }};

        IntStream.range(1, amount)
                 .forEach(index -> bridgeLines.add(createBridgeLine(bridgeLines.get(index - 1), height)));

        return new BridgeLines(bridgeLines);
    }

    private BridgeLine createBridgeLine(final LadderHeight height) {
        return this.createBridgeLine(null, height);
    }

    private BridgeLine createBridgeLine(final BridgeLine previousBridgeLine, final LadderHeight height) {
        List<Boolean> connections = IntStream.range(0, height.getValue())
                                             .mapToObj(h -> {
                                                 if (!Objects.isNull(previousBridgeLine) && previousBridgeLine.isConnected(h)) {
                                                     return false;
                                                 }

                                                 return connectRandomly();
                                             })
                                             .collect(Collectors.toList());
        return new BridgeLine(connections);
    }

    private boolean connectRandomly() {
        return RANDOM.nextBoolean();
    }
}
