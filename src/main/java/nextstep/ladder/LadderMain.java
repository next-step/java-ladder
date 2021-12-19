package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {
    private static final String GAME_RESULT_ALL = "all";

    public static void main(String[] args) {
        String input = InputView.inputEntryMember();
        String itemInput = InputView.inputItems();
        int inputLadderHeight = InputView.inputLadderHeight();

        Names names = Names.from(input);
        Items items = Items.from(itemInput);
        Height height = new Height(inputLadderHeight);
        Ladder ladder = Ladder.of(names.entryMemberCount(), height, new RandomLineStrategy());

        ResultView.gameResult(names, ladder);
        ResultView.printItems(items);

        GameResult gameResult = new GameResult(ladder, names);
        String playerName = InputView.inputResultName();
        while (!GAME_RESULT_ALL.equals(playerName)) {
            ResultView.printPlayerResult(items, gameResult.getResultIndex(new Name(playerName)));
            playerName = InputView.inputResultName();
        }
        ResultView.printGameAllPlayerResult(gameResult, items);
    }
}
