package ladder.view;

import ladder.domain.*;
import ladder.domain.LadderResult;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class ResultView {
    private static final String DEFAULT = "";
    private static final String ALL = "all";
    private static final String PERSON_NAME_FORMAT = "%6s";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String INIT_LINE_SPACE = "      ";
    private static final String NAME_NOT_FOUND = "없는 이름입니다.";
    private static final String NAME_AND_PRIZE_DELIMITER = " : ";

    public static void printLadder(LadderResult ladderGameResult) {
        arrangePersons(ladderGameResult.getPersons());
        System.out.print(NEW_LINE);
        arrangeLadder(ladderGameResult.getLadder());
        arrangeResults(ladderGameResult.getPrizes());
        System.out.print(NEW_LINE);
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

    public static void printResultofPerson(ResultPrize resultPrize){
        Map<String, String> resultMap = resultPrize.getResult();
        String resultName = DEFAULT;

        while (!ALL.equals(resultName)){
            resultName = InputView.inputResult();
            System.out.println(getPrizeByName(resultMap, resultName));
        }
        resultPrize.getResult()
                   .forEach((name, prize) -> {
                    System.out.println(name + NAME_AND_PRIZE_DELIMITER + prize);
                   });

    }

    private static String getPrizeByName(Map<String, String> resultMap, String resultName) {
        String name = DEFAULT;
        if (!ALL.equals(resultName)) {
            name = nameNullCheck(resultMap.get(resultName));
        }
        return name;
    }

    private static String nameNullCheck(String name) {
        if (name == null){
            System.out.println(NAME_NOT_FOUND);
            name = DEFAULT;
        }
        return name;
    }
}
