package nextstep.laddergame.view;

import nextstep.laddergame.domain.*;

import java.util.List;

public class ResultView {
    private static final String RESULT_STRING = "\n실행결과\n";
    private static final String NAME_SEPARATOR = " ";
    private static final String LADDER_PIECE = "|";
    private static final String NO_BRIDGE_STRING = "     ";
    private static final String BRIDGE_STRING = "-----";
    private static final String ALL_TARGET_STRING = "all";

    public static void printResult(Game game, RewardWrapper rewardWrapper) {
        printLadder(game);
        printReward(rewardWrapper);
        printGameResult(game, rewardWrapper);
    }

    private static void printReward(RewardWrapper rewardWrapper) {
        rewardWrapper.getRewards().forEach(reward -> System.out.print(reward + "  "));
        System.out.println();
    }

    private static void printGameResult(Game game, RewardWrapper rewardWrapper) {
        String rewardTarget = InputView.inputRewardTarget();
        if (ALL_TARGET_STRING.equals(rewardTarget)) {
            printAllResult(game, rewardWrapper);
            return;
        }
        Gamer gamer = game.getGamer(rewardTarget);
        int resultIndex = game.getResultIndex(gamer.getIndex());
        System.out.println(rewardWrapper.getReward(resultIndex));
        printGameResult(game, rewardWrapper);
    }

    private static void printAllResult(Game game, RewardWrapper rewardWrapper) {
        List<Integer> resultAll = game.getResultAll();
        for (int index = 0; index < game.getGamers().size(); index++) {
            System.out.println(game.getGamer(index).getName() + ":" + rewardWrapper.getReward(resultAll.get(index)));
        }
    }

    private static void printLadder(Game game) {
        System.out.println(RESULT_STRING);
        for (Gamer gamer : game.getGamers()) {
            System.out.print(gamer.getName() + NAME_SEPARATOR);
        }
        System.out.println();
        for (Line line : game.getLadder().getLines()) {
            printLine(line);
            System.out.println();
        }
    }

    private static void printLine(Line line) {
        for (LadderPiece ladderPiece : line.getLadderPieces()) {
            System.out.print(LADDER_PIECE);
            printBridgeString(ladderPiece);
        }
    }

    private static void printBridgeString(LadderPiece ladderPiece) {
        if (ladderPiece.getBridgePosition().equals(BridgePositionEnum.RIGHT)) {
            System.out.print(BRIDGE_STRING);
            return;
        }
        System.out.print(NO_BRIDGE_STRING);
    }

}
