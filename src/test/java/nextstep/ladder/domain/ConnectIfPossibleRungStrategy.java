package nextstep.ladder.domain;

public class ConnectIfPossibleRungStrategy implements RungStrategy {
    @Override
    public void connect(Junction curr, Junction right) {
        if (curr.hasConnect()) {
            return;
        }

        curr.connectRight(right);
    }
}
