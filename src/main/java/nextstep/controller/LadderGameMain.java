package nextstep.controller;


import nextstep.domain.LadderGame;
import nextstep.view.*;

public class LadderGameMain {
    public static void main(String[] args){
        String userNames = Inputview.inputUserName();
        int maxHeight = Inputview.inputLadderMaxHeight();

        LadderGame ladderGame = new LadderGame(userNames,maxHeight);

        ResultView.printLadder(ladderGame);

    }
}
