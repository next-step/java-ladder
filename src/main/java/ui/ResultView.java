package ui;

import common.StringUtils;
import domain.*;

import java.util.Map;

public class ResultView {
    private static final String EXECUTION_RESULTS_ARE = "실행 결과";
    private static final String LADDER_RESULTS_ARE = "사다리 결과";
    private static final String ALL_RESULTS_PRINT_FORMAT = "%s : %s\n";
    private static final String NEWLINE = "\n";
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-";
    private static final String ALL_RESULTS = "all";
    private static final int NUMBER_OF_TEMPLATE_BLANK = 4;
    private static final int NUMBER_OF_TEMPLATE_HORIZONTAL = 5;

    private ResultView() {}

    public static void printLadderGame(final LadderGame ladderGame) {
        printParticipants(ladderGame.getHeadAndTail().getParticipants());
        printLadder(ladderGame.getLadder());
        printRewards(ladderGame.getHeadAndTail().getRewards());
    }

    private static void printParticipants(final Participants participants) {
        System.out.println(LADDER_RESULTS_ARE);
        participants.getParticipants()
                .forEach( participant -> StringUtils.padAndPrint(participant) );
    }

    private static void printLadder(final Ladder ladder) {
        System.out.print(NEWLINE);
        ladder.getLadder()
                .forEach( ladderLine -> printPoints(ladderLine) );
    }

    private static void printRewards(final Rewards rewards) {
        rewards.getRewards()
                .forEach( reward -> StringUtils.padAndPrint(reward) );
        System.out.print(NEWLINE);
    }

    private static void printPoints(final LadderLine ladderLine) {
        System.out.print(StringUtils.copyAndJoin(NUMBER_OF_TEMPLATE_BLANK, StringUtils.BLANK));
        ladderLine.getPoints().forEach(point -> System.out.print(drawPoint(point)));
        System.out.print(NEWLINE);
    }

    private static String drawPoint(final Point point) {
        return point.isRight() ?
                VERTICAL.concat(StringUtils.copyAndJoin(NUMBER_OF_TEMPLATE_HORIZONTAL, HORIZONTAL)) :
                VERTICAL.concat(StringUtils.copyAndJoin(NUMBER_OF_TEMPLATE_HORIZONTAL, StringUtils.BLANK));
    }


    public static void printResultOf(final String name, final LadderGame ladderGame) {
        if(name.equals(ALL_RESULTS)) {
            printAllResults(ladderGame);
            return;
        }

        System.out.println(EXECUTION_RESULTS_ARE);

        HeadAndTail headAndTail = ladderGame.getHeadAndTail();
        Ladder ladder = ladderGame.getLadder();

        int index = headAndTail.participantsIndexOf(name);
        String result = headAndTail.getRewardAt(ladder.move(index));

        System.out.println(result);
    }

    public static void printAllResults(final LadderGame ladderGame) {
        Map<String, String> allResults = ladderGame.fetchAllResults();

        System.out.println(EXECUTION_RESULTS_ARE);
        for(String key : allResults.keySet()) {
            System.out.printf(ALL_RESULTS_PRINT_FORMAT, key, allResults.get(key)) ;
        }
    }
}
