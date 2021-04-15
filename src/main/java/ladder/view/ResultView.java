package ladder.view;

import ladder.domain.*;

public final class ResultView {

    private static final String EXECUTION_RESULT_MESSAGE = "실행결과";
    private static final String NAME_FORMAT = "%6s";
    private static final String LINE_FORMAT = "%6s";
    private static final String CROSS_LINE = "-----|";
    private static final String NORMAL_LINE = "     |";

    private static class ResultViewHolder {
        private static final ResultView instance = new ResultView();
    }

    private ResultView() {
    }

    public static final ResultView getInstance() {
        return ResultViewHolder.instance;
    }

    public final void printLadderStatus(People people, Ladder ladder, LadderResults results) {
        System.out.println(EXECUTION_RESULT_MESSAGE);
        printPeopleName(people);
        printLadder(ladder);
        int lo = people.countOfPerson();
        for(int i=0; i < lo; i++) {
            System.out.print(String.format(NAME_FORMAT, results.get(i)));
        }
    }


    private final void printLadder(Ladder ladder) {
        ladder.stream()
                .forEach(this::printLine);
    }

    private final void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        line.stream()
                .map(point -> point.hasPoint())
                .map(this::mapToLine)
                .forEach(stringBuilder::append);
        System.out.println(stringBuilder);
    }

    private final String mapToLine(Boolean lineResult) {
        if (lineResult) {
            return String.format(LINE_FORMAT, CROSS_LINE);
        }
        return String.format(LINE_FORMAT, NORMAL_LINE);
    }

    private final void printPeopleName(People people) {
        StringBuilder stringBuilder = new StringBuilder();
        people.stream()
                .map(Person::getName)
                .map(name -> String.format(NAME_FORMAT, name))
                .forEach(stringBuilder::append);
        System.out.println(stringBuilder);
    }

}
