package ladder.view;

import ladder.domain.*;

public class ResultView {

    private static final String LADDER_RESULT_INTRO_MESSAGE = "실행결과";
    public static final String LADDER_HORIZONTAL = "HORIZONTAL";
    public static final String LADDER_EMPTY = "EMPTY";
    public static final String LADDER_VERTICAL = "VERTICAL";

    private StringBuilder uiBuilder = new StringBuilder();

    public void displayLadderplayers(Players players) {
        System.out.println(LADDER_RESULT_INTRO_MESSAGE);
        for (int i = 0; i < players.getPlayerCount(); i++) {
            System.out.print(String.format("%" + Player.NAME_LIMIT + "s", players.getPlayerName(i)));
        }
        System.out.println();
    }

    public void displayLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getLineHeight(); i++) {
            uiBuilder.append(drawLine(ladder.getDrawLine(i)) + "\n");
        }
        System.out.println(uiBuilder.toString());
    }

    private String drawLine(LadderLine ladderLine) {
        String lineString = UI.find(LADDER_EMPTY).getString();
        for (int i = 0; i < ladderLine.getLineSize() - 1; i++) {
            lineString += UI.find(LADDER_VERTICAL).getString();
            lineString += UI.find((i < ladderLine.move(i))
                                    ? LADDER_HORIZONTAL : LADDER_EMPTY).getString();
        }
        lineString += UI.find(LADDER_VERTICAL).getString();
        return lineString;
    }

    public void displayLadderReulst(Rewards rewards) {
        for (int i = 0; i < rewards.getResultCount(); i++) {
            System.out.print(String.format("%" + Player.NAME_LIMIT + "s", rewards.getRewardInfo(i)));
        }
        System.out.println();
    }
}
