package nextstep.view;


import nextstep.ladder.Ladder;
import nextstep.ladder.LadderGame;
import nextstep.ladder.Reward;

import java.util.stream.IntStream;

import static nextstep.ladder.CommonConstans.*;

public class ResultView {

    private static StringBuffer stringLine = new StringBuffer();
    private static Reward rewards;
    private static int playerCount;


    public static void printLadderResult(LadderGame executeLadderGames) {

        playerCount = executeLadderGames.getPlayers().size();
        rewards = Reward.of(playerCount);

        executeLadderGames.getPlayers()
                .stream()
                .map(player -> player.getPlayer() + ONE_BLANK_SPACE)
                .forEach(System.out::print);

        System.out.println(); // player 이름 나열


        IntStream.range(NUMBER_ZERO, executeLadderGames.getladders().size())
                .forEach(i -> drawLadderLine(playerCount, executeLadderGames.getladders().get(i)));

        System.out.print(stringLine); // 사다리 스트링으로 그려주기 .

        rewards.getRewardList().forEach(reward -> System.out.print(reward + ONE_BLANK_SPACE));

        System.out.println(); //보상 리스트 출력.

        IntStream.range(NUMBER_ZERO, executeLadderGames.getPlayers().size())
                .forEach(idx -> rewards.setPlayerList(executeLadderGames.getResultPoint(idx, NUMBER_ZERO))); //플레이어 보상 결과 저장.


        while (true) { //플레이어 보상 검색.
            String findPlayerReward = InputView.insertRewardResult();

            if (findPlayerReward.equals("all")) {
                IntStream.range(NUMBER_ZERO, executeLadderGames.getPlayers().size()).forEach(idx
                        -> System.out.print(rewards.getRewardList().get(rewards.getRewardResult().get(idx)) + ONE_BLANK_SPACE));
                break;
            }

            System.out.println(rewards.getRewardList().get(executeLadderGames.findPlayerReward(findPlayerReward)));
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
