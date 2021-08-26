package laddergameplay.view;

import laddergameplay.domain.Ladder;
import laddergameplay.domain.Line;
import laddergameplay.domain.People;
import laddergameplay.domain.Person;

public class ResultView {

    private static final String LINE_EMPTY = "     |";
    private static final String LINE_EXIST = "-----|";
    private static final int PERSON_DISPLAY_SPACE = Person.MAX_LENGTH_OF_NAME + 1;

    public static void showResult(People people, Ladder ladder) {
        String result = makeResult(people, ladder);

        System.out.println(result);
    }

    private static String makeResult(People people, Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();

        people.getPeople().stream()
                .map(Person::toString)
                .map(name -> String.format("%"+ PERSON_DISPLAY_SPACE +"s", name))
                .forEach(stringBuilder::append);

        ladder.getLadder()
                .forEach(line -> { stringBuilder.append(System.lineSeparator())
                        .append(LINE_EMPTY)
                        .append(makeLineResult(line));
                });

        return stringBuilder.toString();
    }

    private static String makeLineResult(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        line.getPoints().stream()
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


