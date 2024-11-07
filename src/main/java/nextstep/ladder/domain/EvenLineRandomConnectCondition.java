package nextstep.ladder.domain;

import java.util.Random;

public class EvenLineRandomConnectCondition implements ConnectCondition {
    private final Random random = new Random();
    private static EvenLineRandomConnectCondition evenLineRandomConnectCondition;

    public static EvenLineRandomConnectCondition getInstance() {
        if (evenLineRandomConnectCondition == null) {
            evenLineRandomConnectCondition = new EvenLineRandomConnectCondition();
        }
        return evenLineRandomConnectCondition;
    }

    @Override
    public boolean test(Line line) {
        return random.nextInt(10) > 2 && !line.isLeftConnected();
    }
}
