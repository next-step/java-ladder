package ladder;

import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.domain.WinningItems;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Game {

    public static void main(String[] args) {
        List<String> names = InputView.inputNamesOfUsers();
        List<String> items = InputView.inputWinningItems();

        Users users = Users.valueOf(names);
        WinningItems winningItems = new WinningItems(names, items);
        Ladder ladder = Ladder.create(InputView.inputHeightOfLadder(), names.size());

        OutputView.printLadderGameInfo(users, ladder, winningItems);
        OutputView.printResult(InputView.inputResultPersonName(), ladder.calculateLadderResult(users, winningItems));
    }
}
