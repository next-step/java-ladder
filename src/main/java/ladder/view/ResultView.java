package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Person;
import ladder.domain.Persons;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final static String NO_LADDER = "     |";
    private final static String EXIST_LADDER = "-----|";
    private final static String RESULT_SENTENCE = "  실행 결과  ";

    public static void getResultView(Ladder ladder, Persons persons) {
        System.out.println();
        System.out.println(RESULT_SENTENCE);
        System.out.println();
        getPersonsResultView(persons);

        getLadderResultView(ladder);
    }

    private static void getPersonsResultView(Persons persons) {
        String names = persons.getPersons().stream()
                .map(Person::getName)
                .map(name -> String.format("%7s", name))
                .collect(Collectors.joining(""));

        System.out.println(names);
    }

    private static void getLadderResultView(Ladder ladder) {
        ladder.getLines().stream()
                .map(Line::getPoints)
                .forEach(ResultView::makeLadder);

    }

    private static void makeLadder(List<Boolean> line) {
        line.forEach(value -> {
            System.out.print(makeLadder(value));
        });
        System.out.println();
    }
    private static String makeLadder(boolean hasLine) {
        if(hasLine) {
            return EXIST_LADDER;
        }
        return NO_LADDER;
    }

}
