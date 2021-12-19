package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {
    private static final String GAME_RESULT_ALL = "all";

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String input = inputView.inputEntryMember();
        String itemInput = inputView.inputItems();
        int inputLadderHeight = inputView.inputLadderHeight();

        Names names = Names.from(input);
        Items items = Items.from(itemInput);
        Height height = new Height(inputLadderHeight);
        Ladder ladder = Ladder.of(names.entryMemberCount(), height, new RandomLineStrategy());


        ResultView outputView = new ResultView();
        outputView.gameResult(names, ladder);
        outputView.printItems(items);

        GameResult gameResult = new GameResult(ladder, names);
        String playerName = inputView.inputResultName();
        while (!GAME_RESULT_ALL.equals(playerName)) {
            outputView.printPlayerResult(items, gameResult.getResultIndex(new Name(playerName)));
            playerName = inputView.inputResultName();
        }
        outputView.printGameAllPlayerResult(gameResult, items);
    }
}
