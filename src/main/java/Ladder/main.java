package Ladder;

import Ladder.application.LadderController;
import Ladder.view.LadderView;

public class main {
    public static void main(String[] args) {
        new LadderView(new LadderController());
    }
}
