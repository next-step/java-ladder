package ladder.view;

import ladder.domain.*;
import ladder.domain.LadderGameResult;

import java.util.List;

public class ResultView {

    private final static String PERSON_NAME_FORMAT = "%6s";
    private final static String NEW_LINE = System.lineSeparator();
    private static final String INIT_LINE_SPACE = "      ";

    public static void printLadder(LadderGameResult ladderGameResult) {
        arrangePersons(ladderGameResult.getPersons());
        System.out.print(NEW_LINE);
        arrangeLadder(ladderGameResult.getLadder());
        arrangeResults(ladderGameResult.getPrizes());
    }

    private static void arrangePersons(List<Person> persons){
       persons.stream()
              .map(person -> formatWord(person.getName()))
              .forEach(System.out::print);
    }

    private static String formatWord(String name) {
        return String.format(PERSON_NAME_FORMAT, name);
    }

    private static void arrangeLadder(Ladder ladder) {
        ladder.getLayers()
              .forEach(layer -> {
                  System.out.print(INIT_LINE_SPACE);
                  System.out.println(layer.toString());
              });
    }

    private static void arrangeResults(List<String> prizes) {
        prizes.stream()
              .map(result -> formatWord(result))
              .forEach(result -> System.out.print(result));
    }
}
