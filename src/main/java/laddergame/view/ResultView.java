package laddergame.view;

import laddergame.domain.*;

public class ResultView {

    private static final String LINE_EMPTY = "     |";
    private static final String LINE_EXIST = "-----|";

    public static void showResult(People people, Ladder ladder) {
        String result = makeResult(people, ladder);

        System.out.println(result);
    }

    private static String makeResult(People people, Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();

        people.stream()
                .map(Person::getName)
                .map(name -> String.format("%"+ (Person.MAX_LENGTH_OF_NAME+1) +"s", name))
                .forEach(stringBuilder::append);

        ladder.stream()
                .forEach(line -> { stringBuilder.append(System.lineSeparator())
                        .append(LINE_EMPTY)
                        .append(makeLineResult(line));
                });

        return stringBuilder.toString();
    }

    private static String makeLineResult(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        line.stream()
                .map(ResultView::ladderString)
                .forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    private static String ladderString(Boolean bool) {
        if (bool) {
            return LINE_EXIST;
        }
        return LINE_EMPTY;
    }
}


