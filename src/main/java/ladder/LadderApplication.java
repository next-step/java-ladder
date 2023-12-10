package ladder;

import ladder.domain.LadderGame;

import static ladder.view.IOView.*;

/*
pobi,qwe,qq,qwer
* */
public class LadderApplication {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(inputPlayer(), inputHeight());

        ladderGame.play();
    }

}
