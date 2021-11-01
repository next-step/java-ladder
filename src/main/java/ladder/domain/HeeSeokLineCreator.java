package ladder.domain;

import ladder.engine.LineCreator;

public class HeeSeokLineCreator implements LineCreator {

    @Override
    public Line create(int sizeOfUsers) {
        Line newLine = new Line(sizeOfUsers);
        newLine.drawOneLine();
        return newLine;
    }
}
