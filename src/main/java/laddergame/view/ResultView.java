package laddergame.view;

import laddergame.domain.*;

import java.util.List;

public class ResultView {

    private static final String LINE_EMPTY = "     |";
    private static final String LINE_EXIST = "-----|";

    public static void showResult(LadderGame ladderGame) {
        List<Person> people = ladderGame.getPeople();
        List<Line> ladder = ladderGame.getLadder();

        people.stream()
                .map(Person::getName)
                .forEach(name -> System.out.printf("%"+ (Person.MAX_LENGTH_OF_NAME+1) +"s", name));

        ladder.forEach(line -> {
                System.out.println();
                System.out.print(LINE_EMPTY);
                line.getPoints().stream()
                        .map(ResultView::ladderString)
                        .forEach(System.out::print);
                });
    }

    private static String ladderString(Boolean bool) {
        if (bool) {
            return LINE_EXIST;
        }
        return LINE_EMPTY;
    }
}


