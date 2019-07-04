package ladder.view;

import ladder.domain.*;

import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ResultView {
    private static final String FIRST_FORMAT = "    |";
    private static final String BLANK_FORMAT = "     ";
    private static final String LINE_FORMAT = "-----";
    private static final String POLE_FORMAT = "|";
    private static final String NAME_FORMAT = "%5s ";
    private static final String ALL = "all";

    public static void outputOfLadderGame(LadderGame ladderGame, Rewards rewards) {
        changeNextLine();
        System.out.println("실행 결과");
        printPlayers(ladderGame.getPlayers());
        changeNextLine();
        printLadder(ladderGame.getLadder());
        printRewards(rewards);
        changeNextLine();
    }

    private static void printPlayers(Players players) {
        players.getStream()
                .forEach(player -> System.out.print(String.format(NAME_FORMAT, player.getName())));
    }

    private static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLadder()) {
            String ladderLine = line.getStream()
                    .map(x -> x ? LINE_FORMAT : BLANK_FORMAT)
                    .collect(Collectors.joining(POLE_FORMAT));
            System.out.println(FIRST_FORMAT + ladderLine + POLE_FORMAT);
        }
    }

    private static void printRewards(Rewards rewards) {
        rewards.getStream()
                .forEach(reward -> System.out.print(String.format(NAME_FORMAT, reward.getReward())));
        changeNextLine();
    }

    public static void outputOfLadderResult(LadderResult ladderResult) {
        while (true) {
            String input = InputView.ResultByInputPlayer();
            changeNextLine();

            System.out.println("실행 결과");
            printResultByPlayerOrPlayers(ladderResult, input);
            changeNextLine();
        }
    }

    private static void printResultByPlayerOrPlayers(LadderResult ladderResult, String input) {
        System.out.println(input.equals(ALL) ? resultOfPlayers(ladderResult) : resultOfPlayer(ladderResult, input));
    }

    private static String resultOfPlayer(LadderResult ladderResult, String input) {
        return ladderResult.rewardOfPlayer(input);
    }

    private static String resultOfPlayers(LadderResult ladderResult) {
        StringJoiner result = new StringJoiner("\n");
        ladderResult.getForEach((player, reward) -> result.add(player.getName() + " : " + reward.getReward()));
        return result.toString();
    }

    private static void changeNextLine() {
        System.out.println();
    }
}
