package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.Horizontal;

public class LineMaker {
    private final int sizeOfUsers;

    public LineMaker(int sizeOfUsers) {
        this.sizeOfUsers = sizeOfUsers;
    }

    public Line makeLine() {
        Line line = new Line();
        for (int j = 0; j < this.sizeOfUsers; j++) {
            line.add(new Horizontal(RandomNumberGenerator.generate(), line.isLeft()));
        }

        return line;
    }
}
