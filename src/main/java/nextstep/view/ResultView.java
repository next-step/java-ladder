package nextstep.view;


import nextstep.ladder.Ladder;
import nextstep.ladder.LadderGame;
import nextstep.ladder.Player;
import nextstep.ladder.Reward;

import java.util.stream.IntStream;

import static nextstep.ladder.CommonConstans.*;

public class ResultView {

    private static StringBuffer stringLine = new StringBuffer();
    private static int playerCount;


    public static void printLadderResult(LadderGame ladderGame, Reward rewards) {

        playerCount = ladderGame.getPlayers().size();


        ladderGame.setLadders(InputView.insertLadderHeight());


        for (Player player : ladderGame.getPlayers()) {
            System.out.print(player.getPlayer() + ONE_BLANK_SPACE);
        }

        System.out.println(); // player 이름 나열


        IntStream.range(NUMBER_ZERO, ladderGame.getladders().size())
                .forEach(i -> drawLadderLine(playerCount, ladderGame.getladders().get(i)));

        System.out.print(stringLine); // 사다리 스트링으로 그려주기 .

        rewards.getRewardList().forEach(r -> System.out.print(r + ONE_BLANK_SPACE));

        System.out.println(); //보상 리스트 출력.


        while (true) { //플레이어 보상 검색.
            String findPlayerReward = InputView.insertRewardResult();

            if (findPlayerReward.equals("all")) {
                for (Player findPlayer : ladderGame.getPlayers()) {
                    System.out.print(ladderGame.findPlayerReward(rewards.getRewardList(), findPlayer.getPlayer()) + ONE_BLANK_SPACE);
                }
                break;
            }

            System.out.println(ladderGame.findPlayerReward(rewards.getRewardList(), findPlayerReward));
        }
    }


    private static void drawLadderLine(int playerCount, Ladder ladder) {

        IntStream.range(NUMBER_ZERO, playerCount)
                .forEach(index -> createStringLine(ladder.getLines().get(index), index));
        stringLine.append("\n");
    }

    private static void createStringLine(boolean line, int index) {
        if (index == (playerCount - NUMBER_ONE)) {
            stringLine.append(FALSE_LINE);
            return;
        }

        if (line) {
            stringLine.append(TRUE_LINE);
            return;
        }
        stringLine.append(FALSE_LINE);
    }


}
