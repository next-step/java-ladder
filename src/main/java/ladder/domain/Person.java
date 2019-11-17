package ladder.domain;

import java.util.List;

public class Person {

    private static final int PREVIOUS_CORRECTION = 1;
    private static final int NAME_MAX_LENGTH = 6;
    private static final int NAME_LENGTH = 5;

    private String name;
    private int startIndex;
    private int resultIndex;

    Person(String name, int startIndex) {
        this.name = name;
        this.startIndex = startIndex;
        this.resultIndex = 0;
    }

    public Person result(List<Line> lines) {
        resultIndex = getResult(lines, this.startIndex);
        return this;
    }

    private int getResult(List<Line> lines, int index) {
        for (Line ladderLine : lines) {
            index += move(ladderLine, index);
        }
        return index;
    }

    private int move(Line line, int index) {
        if (index == 0) {
            return moveToFirstIndex(line, index);
        }
        return MovingOperator.getPosition(new Moving(line.isPoint(index - PREVIOUS_CORRECTION), line.isPoint(index)));
    }

    private int moveToFirstIndex(Line line, int index) {
        if (line.isPoint(index)) {
            return MovingOperator.getPosition(Moving.right());
        } return MovingOperator.getPosition(Moving.stay());
    }

    public int getResultIndex() {
        return resultIndex;
    }

    public String getName() {
        return name;
    }

    public int getEmptyLength() {
        return NAME_MAX_LENGTH - name.length();
    }

    public boolean isNameLength() {
        return this.name.length() <= NAME_LENGTH;
    }

    void validate() {
        if (this.name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
