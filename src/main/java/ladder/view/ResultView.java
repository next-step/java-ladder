package ladder.view;

import ladder.domain.*;
import ladder.dto.LadderResponseDto;

public class ResultView {
    private final static String PERSON_NAME_FORMAT = "%6s";
    private final static String NEW_LINE = System.lineSeparator();

    public static void print(LadderResponseDto ladderResponseDto) {
        arrangePersons(ladderResponseDto.getPersons());
        System.out.print(NEW_LINE);
        arrangeLadder(ladderResponseDto.getLadder());
        arrangeResults(ladderResponseDto.getLadderResults());
    }

    private static void arrangePersons(Persons persons){
       persons.getPersons()
              .stream()
              .map(person -> formatWord(person.getName()))
              .forEach(name -> {
                  System.out.print(name);
              });
    }

    private static String formatWord(String name) {
        return String.format(PERSON_NAME_FORMAT, name);
    }

    private static void arrangeLadder(Ladder ladder) {
        ladder.getLayers()
              .stream()
              .forEach(line -> {
                  System.out.println(line.toString());
              });
    }

    private static void arrangeResults(LadderResults ladderResults) {
        ladderResults.getLadderResults()
                     .stream()
                     .map(result -> formatWord(result))
                     .forEach(result -> System.out.print(result));
    }
}
