package ladder.domain.ladder.line;

import java.util.concurrent.ThreadLocalRandom;

public class RandomConnectionGenerator implements ConnectionGenerator {

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public Connection generateFirst() {
        return Connection.first(random.nextBoolean());
    }

    @Override
    public Connection generateNext(final Connection previousConnection) {
        if (previousConnection.isRightConnected()) {
            return previousConnection.next(false);
        }

        return previousConnection.next(random.nextBoolean());
    }
}
