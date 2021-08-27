package nextstep.step4.view;


import nextstep.step4.LadderGame;
import nextstep.step4.LadderLine;
import nextstep.step4.LadderResult;
import nextstep.step4.Reward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static nextstep.ladder.CommonConstans.ONE_BLANK_SPACE;

public class ResultView {

    public static void printLadderResult(String[] players, String reward) {

        List<LadderLine> ladderLines = new ArrayList<>();

        Reward rewards = Reward.of(reward, players.length);

        int ladderHeight = InputView.insertLadderHeight();

        for (int i = 0; i < ladderHeight; i++) {
            ladderLines.add(LadderLine.init(players.length));
        }

        LadderGame ladderGame = LadderGame.of(players.length, ladderLines);

        System.out.println("사다리 결과");

        Arrays.stream(players).forEach(player -> System.out.print(player + ONE_BLANK_SPACE));

        System.out.println();

        System.out.println(ladderGame.drawLadderLines());

        System.out.println(rewards.getStringRewards());


        LadderResult ladderResult = ladderGame.playLadder();


        while (true) { //플레이어 보상 검색.
            String findPlayerReward = InputView.insertRewardResult();

            if (findPlayerReward.equals("all")) {
                for (int i = 0; i < players.length; i++) {
                    System.out.println(rewards.rewardResult(ladderResult.getEndPoint(i)));
                }

                break;
            }

            int findPlayerIndex = Arrays.asList(players).indexOf(findPlayerReward);

            System.out.println(rewards.rewardResult(ladderResult.getEndPoint(findPlayerIndex)));
        }


    }

}
