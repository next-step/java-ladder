package ladder.domain;

import java.util.Iterator;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final int lineIndex;

    public Player(String name, int lineIndex) {
        checkNameLength(name);
        this.name = name;
        this.lineIndex = lineIndex;
    }

    private void checkNameLength(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 최대길이는 5자입니다.");
        }
    }

    public int playLadder(Ladder ladder) {
        int index = this.lineIndex;
        Iterator<Line> lines = ladder.iterator();
        while(lines.hasNext()) {
            Line line = lines.next();
            index += line.move(index);
        }

        return index;
    }

    @Override
    public String toString() {
        return String.format("%6s", this.name);
    }
}
