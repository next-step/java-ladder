package JavaLadder;

import JavaLadder.domain.*;
import JavaLadder.view.InputView;
import JavaLadder.view.OutputView;

public class JavaLadder {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputName = inputView.askName();
        UserList userList = new UserList(inputName);

        String prize = inputView.askPrize();
        PrizeList prizeList = new PrizeList(prize);

        validateSize(userList, prizeList);

        int ladderHeight = inputView.askLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, userList.size());

        OutputView outputView = new OutputView();
        outputView.showLadder(userList, ladder, prizeList);

        ladder.moveForResult(userList);

        String resultBuyPerson = inputView.askResultByPerson();

        ResultList resultList = new ResultList(userList, resultBuyPerson);

        outputView.showResult(resultList, prizeList);
    }

    public static void validateSize(UserList userList, PrizeList prizeList) {
        if (userList.size() != prizeList.size()){
            throw new IllegalArgumentException("사람입력 수(" + userList.size() + ")와 실행결과입력 수(" + prizeList.size() + ")같아야합니다.");
        }
    }
}
