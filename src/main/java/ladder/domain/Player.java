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

    public int playLadder(Ladder ladder) {
        int index = this.lineIndex;
        Iterator<LadderLine> lines = ladder.iterator();
        while(lines.hasNext()) {
            LadderLine ladderLine = lines.next();
            index = ladderLine.move(index);
        }

        return index;
    }

    private void checkNameLength(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 최대길이는 5자입니다.");
        }
    }

    @Override
    public String toString() {
        return String.format("%6s", this.name);
    }
}
