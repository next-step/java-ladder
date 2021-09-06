package ladder;

import ladder.domain.*;
import ladder.exception.LadderHeightException;
import ladder.exception.NotFoundUserException;
import ladder.exception.UserNameLengthException;

import static ladder.view.InputView.*;
import static ladder.view.InputView.askLadderHeight;
import static ladder.view.ResultView.*;

public class LadderApplication {
    public static void main(String[] args) {
        Users users = getUsers();

        int winningItemsCount = users.usersCount();
        WinningItems winningItems = getWinningItems(winningItemsCount);

        LadderHeight ladderHeight = ladderHeight();
        Ladder ladder = new Ladder(ladderHeight, users.usersCount());

        printUserList(users);
        printLadder(ladder);
        printWinningItems(winningItems);

        MatchResults matchResults = new MatchResults(ladder.results(users, winningItems));

        while (true) {
            getWhoResult(matchResults, users);
        }

    }

    private static LadderHeight ladderHeight() {
        try {
            int height = askLadderHeight();
            return new LadderHeight(height);
        } catch (LadderHeightException e) {
            System.out.println("사다리 높이 1 이상으로 입력하세요.");
            return ladderHeight();
        }
    }

    private static Users getUsers() {
        String[] usersName = askUserName();
        try {
            return new Users(usersName);
        } catch (UserNameLengthException e) {
            System.out.println("유저 이름을 잘못 입력 하셨습니다.");
            return getUsers();
        }
    }

    private static WinningItems getWinningItems(int count) {
        String[] winningItems = askWinningItems();
        if (winningItems.length != count) {
            System.out.println("참여자 숫자 만큼 당첨 항목을 입력하세요\n");
            return getWinningItems(count);
        }
        return new WinningItems(winningItems);
    }

    private static void getWhoResult(MatchResults matchResult, Users users) {
        String name = askWhoResult();

        if (name.isEmpty() || name == null) {
            System.out.println("입력하지 않으셨습니다.\n");
            getWhoResult(matchResult, users);
        }
        if (name.equals("all")) {
            printAllResult(matchResult);
            return;
        }

        try {
            User user = users.getUserToName(name);
            printResult(matchResult, user);
        } catch (NotFoundUserException e) {
            System.out.println("사람 이름 잘못 입력했어요\n");
            getWhoResult(matchResult, users);
        }

    }

}
