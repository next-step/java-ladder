package laddergame.view;

import laddergame.domain.*;

import java.util.List;

public class ResultView {

    private static final String LINE_EMPTY = "     |";
    private static final String LINE_EXIST = "-----|";

    public static void showResult(LadderGame ladderGame) {
        List<Person> people = ladderGame.getPeople();
        List<Line> ladder = ladderGame.getLadder();

        String result = makeResult(people, ladder);

        System.out.println(result);
    }

    private static String makeResult(List<Person> people, List<Line> ladder) {
        StringBuilder sb = new StringBuilder();

        people.stream()
                .map(Person::getName)
                .map(name -> String.format("%"+ (Person.MAX_LENGTH_OF_NAME+1) +"s", name))
                .forEach(sb::append);

        ladder.forEach(line -> {
            sb.append(System.lineSeparator())
                    .append(LINE_EMPTY)
                    .append(makeLineResult(line));
        });

        return sb.toString();
    }

    private static String makeLineResult(Line line) {
        StringBuilder sb = new StringBuilder();
        line.getPoints().stream()
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


