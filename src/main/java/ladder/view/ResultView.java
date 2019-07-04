package ladder.view;

import java.util.stream.Collectors;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderResult;
import ladder.domain.Line;
import ladder.domain.Players;
import ladder.domain.Reward;
import ladder.domain.Rewards;

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
    }
    
    public static void outputOfLadderResult(LadderResult ladderResult) {
        while(true) {
        	String input = InputView.ResultByInputPlayer();
        	changeNextLine();
        	Reward reward = ladderResult.rewardOfPlayer(input);
        	System.out.println("실행 결과");
        	System.out.println(reward.getReward());
        	changeNextLine();
        }
    }

    private static void changeNextLine() {
        System.out.println();
    }
}
