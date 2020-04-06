package JavaLadder;

import JavaLadder.domain.Ladder;
import JavaLadder.domain.PrizeList;
import JavaLadder.domain.UserList;
import JavaLadder.view.InputView;
import JavaLadder.view.OutputView;

public class JavaLadder {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputName = inputView.askName();
        UserList userList = new UserList(inputName);
        int ladderHeight = inputView.askLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, userList.size());
        OutputView outputView = new OutputView();
        outputView.result(userList, ladder);
    }


    public static boolean validateSize(UserList userList, PrizeList prizeList) {
        return userList.size() == prizeList.size();
    }
}
