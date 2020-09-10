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

    public void move(Person personByName) {
        if (isOutOfLeftBound(personByName)) {
            compareWithRightSide(personByName);
        }
        if (isOutOfRightBound(personByName)) {
            compareWithLeftSide(personByName);
        }
        if (isInTheBound(personByName)) {
            compareWithLeftSide(personByName);
            compareWithRightSide(personByName);
        }

    }

    private boolean isInTheBound(Person personByName) {
        return personByName.printCurrentPosition().getLeftPosition() >= 0 && personByName.printCurrentPosition().getRightPosition() <= rungs.size();
    }

    private boolean isOutOfLeftBound(Person personByName) {
        return personByName.printCurrentPosition().getLeftPosition() < 0;
    }

    private boolean isOutOfRightBound(Person personByName) {
        return personByName.printCurrentPosition().getRightPosition() > rungs.size();
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
}
