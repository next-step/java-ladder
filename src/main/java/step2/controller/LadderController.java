package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;


public class LadderController {

    public static Players getPlayers() {
        return Players.of(InputView.getPlayers());
    }

    public static int getHeight() {
        return InputView.getLadderHeight();
    }

    public static Lines createLines(int size, int height) {
        return Lines.of(height, size, new PointCondition());
    }

    public static void showResult(Players players, Lines lines) {
        ResultView.printPlayer(players);
        ResultView.printLadder(lines);
    }
}
