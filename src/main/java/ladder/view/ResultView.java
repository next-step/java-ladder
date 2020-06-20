package ladder.view;

import ladder.domain.*;
import ladder.dto.LadderResponseDto;

public class ResultView {
    private final static String PERSON_NAME_FORMAT = "%6s";
    private final static String NEW_LINE = System.lineSeparator();
    private static final String INIT_LINE_SPACE = "      ";

    public static void printLadder(LadderResponseDto ladderResponseDto) {
        arrangePersons(ladderResponseDto.getPersons());
        System.out.print(NEW_LINE);
        arrangeLadder(ladderResponseDto.getLadder());
        arrangeResults(ladderResponseDto.getLadderResults());
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

    private static void arrangeResults(LadderResults ladderResults) {
        ladderResults.getLadderResults()
                     .stream()
                     .map(result -> formatWord(result))
                     .forEach(result -> System.out.print(result));
    }
}
