package reladder;

import reladder.service.LadderGame;
import reladder.view.ResultView;

public class LadderResponse {

    private static final String END_KEY = "all";

    public static void main(String[] args) {

        LadderRequest ladderRequest = new LadderRequest();
        LadderGame ladderGame = ladderRequest.create(ladderRequest.register());
        ResultView.printLadderGame(ladderGame);

        String request = ladderRequest.request();
        while (!request.equals(END_KEY)) {
            ResultView.printResultOnce(ladderRequest.response(ladderGame, request));
            request = ladderRequest.request();
        }
        ResultView.printResult(ladderRequest.responseAll(ladderGame));
    }
}
