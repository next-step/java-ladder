package ladder;

import ladder.domain.LadderGame;
import ladder.service.LadderService;
import ladder.view.InputView;

public class LadderApplication {

    public static void main(String[] args) {
        LadderService ladderService = new LadderService();

        String names = InputView.inputNames();
        String height = InputView.inputHeight();

        LadderGame ladder = ladderService.createLadder(names, height);
        System.out.println(ladder);
    }
}
