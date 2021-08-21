package laddergame.view;

import laddergame.domain.*;

import java.util.List;

public class ResultView {

    private static final String LINE_EMPTY = "     |";
    private static final String LINE_EXIST = "-----|";

    public static void showResult(LadderGame ladderGame) {
        People people = ladderGame.getPeople();
        Ladder ladder = ladderGame.getLadder();

        String result = makeResult(people, ladder);

        System.out.println(result);
    }

    private static String makeResult(People people, Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        people.stream()
                .map(Person::getName)
                .map(name -> String.format("%"+ (Person.MAX_LENGTH_OF_NAME+1) +"s", name))
                .forEach(sb::append);

        ladder.stream()
                .forEach(line -> { sb.append(System.lineSeparator())
                        .append(LINE_EMPTY)
                        .append(makeLineResult(line));
                });

        return sb.toString();
    }

    private static String makeLineResult(Line line) {
        StringBuilder sb = new StringBuilder();
        line.stream()
                .map(ResultView::ladderString)
                .forEach(sb::append);
        return sb.toString();
    }

    private static String ladderString(Boolean bool) {
        if (bool) {
            return LINE_EXIST;
        }
        return LINE_EMPTY;
    }
}


