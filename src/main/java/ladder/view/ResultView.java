package ladder.view;

import ladder.domain.*;
import ladder.domain.LadderGameInfo;

public class ResultView {

    private final static String PERSON_NAME_FORMAT = "%6s";
    private final static String NEW_LINE = System.lineSeparator();
    private static final String INIT_LINE_SPACE = "      ";

    public static void printLadder(LadderGameInfo ladderGameInfo) {
        arrangePersons(ladderGameInfo.getPersons());
        System.out.print(NEW_LINE);
        arrangeLadder(ladderGameInfo.getLadder());
        arrangeResults(ladderGameInfo.getPrizes());
    }

    private static void arrangePersons(Persons persons){
       persons.getPersons()
              .stream()
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

    private static void arrangeResults(Prizes prizes) {
        prizes.getPrizes()
                     .stream()
                     .map(result -> formatWord(result))
                     .forEach(result -> System.out.print(result));
    }
}
