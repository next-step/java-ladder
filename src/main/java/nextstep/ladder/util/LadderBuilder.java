package nextstep.ladder.util;

import nextstep.ladder.domain.Bridges;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Width;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderBuilder {

    private static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    public static Ladder build(Width width, Height height) {
        List<Bridges> ladder = Stream.generate(width::value)
            .map(LadderBuilder::buildBridges)
            .limit(height.value())
            .collect(Collectors.toUnmodifiableList());

        return new Ladder(ladder);
    }

    private static Bridges buildBridges(int width) {
        BridgeBuilder bridgeBuilder = new BridgeBuilder();

        return Stream.generate(RANDOM::nextBoolean)
            .map(bridgeBuilder::build)
            .limit(width)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Bridges::new));
    }

    static class BridgeBuilder {

        private boolean bridge;

        private BridgeBuilder() {
            this.bridge = RANDOM.nextBoolean();
        }

        private boolean build(boolean bridge) {
            if (this.bridge) {
                this.bridge = false;
                return false;
            }

            this.bridge = bridge;
            return bridge;
        }
    }
}