package ladder.view;

import ladder.domain.*;

public class ResultView {

    private static final String LADDER_RESULT_INTRO_MESSAGE = "실행결과";
    private StringBuilder uiBuilder = new StringBuilder();

    public void displayLadderplayers(Players players) {
        System.out.println(LADDER_RESULT_INTRO_MESSAGE);
        System.out.println(players.getPlayerName());
    }

    public void displayLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getLineHeight(); i++) {
            uiBuilder.append(drawLine(ladder.getDrawLine(i)) + "\n");
        }
        System.out.println(uiBuilder.toString());
    }

    private String drawLine(Line line){
        String lineString = UI.find(Draw.of(false)).getString() + UI.find().getString();
        for (int i = 0; i < line.getDrawLineCount(); i++) {
            lineString += UI.find(line.getDrawByPosition(i)).getString() + UI.find().getString();
        }
        return lineString;
    }
}
