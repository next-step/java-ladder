package nextstep.ladder.domain;

public class CreateIfPossibleCreateRungStrategy implements CreateRungStrategy {
    @Override
    public void create(Junction curr, Junction right) {
        if (curr.hasConnect()) {
            return;
        }

        curr.connectRight(right);
    }
}
