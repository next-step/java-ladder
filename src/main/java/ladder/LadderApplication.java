package ladder;

import ladder.domain.*;
import ladder.exception.NotFoundUserException;

import static ladder.view.InputView.*;
import static ladder.view.ResultView.*;

public class LadderApplication {
    public static void main(String[] args) {
        String[] usersName = askUserName();
        Users users = new Users(usersName);

        int winningItemsCount = usersName.length;
        WinningItems winningItems = getWinningItems(winningItemsCount);

        int ladderHeight = askLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, usersName.length);

        printUserList(users);
        printLadder(ladder);
        printWinningItems(winningItems);

        MatchResult matchResult = new MatchResult(users, ladder, winningItems);

        while (true) {
            getWhoResult(matchResult, users);
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

    private static void getWhoResult(MatchResult matchResult, Users users) {
        String name = askWhoResult();
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
