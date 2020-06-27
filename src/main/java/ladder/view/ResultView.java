package ladder.view;

import ladder.domain.*;
import ladder.domain.LadderResult;

import java.util.List;

public class ResultView {
    private static final String DEFAULT = "";
    private static final String ALL = "all";
    private static final String NAME_NOT_FOUND = "없는 이름입니다.";
    private static final String NAME_AND_PRIZE_DELIMITER = " : ";

    public static void printLadder(LadderResult ladderGameResult) {
        arrangePersons(ladderGameResult.getPersons());
        arrangeLadder(ladderGameResult.getLadder());
        arrangeResults(ladderGameResult.getPrizes());
    }

    private static void arrangePersons(Persons persons){
        System.out.println(persons.toString());
    }

    private static void arrangeLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

    private static void arrangeResults(Prizes prizes) {
        System.out.println(prizes.toString());
    }

    public static void printResultofPerson(List<ResultPrize> resultPrizes){
        String resultName = DEFAULT;

        while (!ALL.equals(resultName)){
            resultName = InputView.inputResult();
            System.out.println(getPrizeByName(resultPrizes, resultName));
        }
        resultPrizes.forEach(resultPrize -> {
            System.out.println(resultPrize.getPersonName() + NAME_AND_PRIZE_DELIMITER + resultPrize.getPrizeValue());
                   });

    }

    private static String getPrizeByName(List<ResultPrize> resultPrizes, String resultName) {
        String name = DEFAULT;
        if (!ALL.equals(resultName)) {
            name = resultPrizes.stream()
                    .filter(resultPrize -> resultPrize.checkEqaulName(resultName))
                    .map(resultPrize -> resultPrize.getPrizeValue())
                    .findAny()
                    .orElse(NAME_NOT_FOUND);
        }
        return name;
    }
}
