package step2.model;

import step2.strategy.DrawStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Line {
    private List<Boolean> rungs = new ArrayList<>();

    public void drawNewLine(int countOfPerson, DrawStrategy strategy) {
        for (int loop = 0; loop < countOfPerson - 1; loop++) {
            rungs.add(draw(strategy));
        }
    }

    public boolean draw(DrawStrategy strategy) {
        boolean drawResult = strategy.draw();
        return isEmptyAndDrawn(drawResult) || isRungFalseAndDrawnNow(drawResult);
    }

    private boolean isEmptyAndDrawn(boolean drawnResult) {
        return rungs.isEmpty() && drawnResult;
    }

    private boolean isRungFalseAndDrawnNow(boolean drawnResult) {
        return isRungsNotEmpty() && isLastRungFalse() && drawnResult;
    }

    private boolean isLastRungFalse() {
        return !rungs.get(rungs.size() - 1);
    }

    private boolean isRungsNotEmpty() {
        return rungs.size() > 0;
    }

    public String printRungs() {
        return rungs.toString();
    }

    public Boolean getRungOfPosition(int position) {
        return Optional.of(rungs.get(position))
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getNumberOfRung() {
        return rungs.size();
    }

    public boolean move(Person personByName) {
        Position position = personByName.printCurrentPosition();
        if (isOutOfLeftBound(position)) {
            compareWithRightSide(personByName);
            return true;
        }
        if (isOutOfRightBound(position)) {
            compareWithLeftSide(personByName);
            return true;
        }
        if (isInTheBound(position)) {
            compareWithLeftRightSide(personByName);
            return true;
        }
        return false;
    }

    private boolean isInTheBound(Position position) {
        return position.getLeftPosition() >= 0 && position.getRightPosition() <= getNumberOfRung();
    }

    private boolean isOutOfLeftBound(Position position) {
        return position.getLeftPosition() < 0;
    }

    private boolean isOutOfRightBound(Position position) {
        return position.getRightPosition() > getNumberOfRung();
    }

    private void compareWithLeftSide(Person personByName) {
        if (rungs.get(personByName.printCurrentPosition().getLeftPosition())) {
            personByName.printCurrentPosition().move(Movement.LEFT);
        }
    }

    private void compareWithRightSide(Person person) {
        if (rungs.get(person.printCurrentPosition().getPosition())) {
            person.printCurrentPosition().move(Movement.RIGHT);
        }
    }

    private void compareWithLeftRightSide(Person personByName) {
        Boolean rung = rungs.get(personByName.printCurrentPosition().getLeftPosition());
        if (rung) {
            personByName.printCurrentPosition().move(Movement.LEFT);
        }
        if (!rung) {
            personByName.printCurrentPosition().move(Movement.RIGHT);
        }
    }
}
