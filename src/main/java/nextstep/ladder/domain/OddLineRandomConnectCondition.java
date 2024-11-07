package nextstep.ladder.domain;

import java.util.Random;

public class OddLineRandomConnectCondition implements ConnectCondition {
    private final Random random = new Random();
    private static OddLineRandomConnectCondition oddLineRandomConnectCondition;

    public static OddLineRandomConnectCondition getInstance() {
        if (oddLineRandomConnectCondition == null) {
            oddLineRandomConnectCondition = new OddLineRandomConnectCondition();
        }
        return oddLineRandomConnectCondition;
    }

    @Override
    public boolean test(Line line) {
        return random.nextInt(10) > 5 && !line.isLeftConnected();
    }
}
