package step2;

import step2.view.InputView;

public class LadderApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String nameOfParticipant = inputView.requireNameOfParticipant();
        int heightOfLadder = inputView.requireHeightOfLadder();
        
    }
}
