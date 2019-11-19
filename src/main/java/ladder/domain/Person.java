package ladder.domain;

import java.util.List;

public class Person {

    private static final int PREVIOUS_CORRECTION = 1;
    private static final int NAME_MAX_LENGTH = 6;
    private static final int NAME_LENGTH = 5;
    private static final int LADDER_BOUND_START_POSITION = 0;

    private String name;
    private int position;

    Person(String name, int position) {
        this.name = name;
        this.position = position;
        validate();
    }

    public Person result(List<Line> lines) {
        this.position = getResult(lines, this.position);
        return this;
    }

    private int getResult(List<Line> lines, int index) {
        for (Line ladderLine : lines) {
            index += move(ladderLine, index);
        }
        return index;
    }

    private int move(Line line, int index) {
        if (index == LADDER_BOUND_START_POSITION) {
            return moveToFirstIndex(line, index);
        }
        return MovingOperator.getPosition(new Moving(line.isPoint(index - PREVIOUS_CORRECTION), line.isPoint(index)));
    }

    private int moveToFirstIndex(Line line, int index) {
        if (line.isPoint(index)) {
            return MovingOperator.getPosition(Moving.right());
        }
        return MovingOperator.getPosition(Moving.stay());
    }

    boolean isName(String name) {
        return this.name.equals(name);
    }

    public int getPosition() {
        return this.position;
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

    private void validate() {
        if (this.name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
