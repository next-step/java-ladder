package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.People;

public class ResultView {
    private static final String RESULT_TITLE = "실행 결과";
    private static final String NAME_FORMAT = "%6s";

    public void printResult(People people, Ladder ladder) {
        printTitle();
        printPeopleNames(people);
        printLadder(ladder);
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    private void printTitle() {
        System.out.println(RESULT_TITLE);
        System.out.println();
    }

    private void printPeopleNames(People people) {
        people.getPeopleNames()
            .forEach(name -> System.out.printf(NAME_FORMAT, name));
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines()
            .forEach(this::printLine);
    }

    private void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append("     |");

        line.getMovingPoints()
            .forEach(point -> sb.append(getFormattedMovingPoint(point)));

        System.out.println(sb);
    }

    private String getFormattedMovingPoint(boolean point) {
        return point ? "-----|" : "     |";
    }
}
