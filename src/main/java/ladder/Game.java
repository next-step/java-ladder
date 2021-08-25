package ladder;

import ladder.domain.Ladder;
import ladder.domain.Result;
import ladder.domain.Users;
import ladder.domain.WinningItems;
import ladder.exception.InvalidInputException;
import ladder.view.InputView;

import java.util.List;

public class Game {
    private static final String INVALID_WINNING_ITEMS_MESSAGE = "실행 결과의 갯수가 올바르지 않습니다.";

    public static void main(String[] args) {
        List<String> names = InputView.inputNamesOfUsers();
        List<String> items = InputView.inputWinningItems();
        validateItems(names, items);

        Users users = Users.valueOf(names);
        WinningItems winningItems = new WinningItems(items);
        Ladder ladder = Ladder.create(InputView.inputHeightOfLadder(), names.size());

        Result result = new Result(users, ladder, winningItems);
        result.printLadderInfo();
        result.calculateLadderResult();
        result.printResult(InputView.inputResultPersonName());
    }

    private static void validateItems(List<String> names, List<String> items) {
        if (names.size() != items.size()) {
            throw new InvalidInputException(INVALID_WINNING_ITEMS_MESSAGE);
        }
    }
}
