package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.constant.PrintMessage.PRINT_TEXT_RESULT;

public class ResultView {

    private final String UNIT_LADDER_CHARACTOR = "|";
    private final String UNIT_BRIDGE_CHARACTOR = "-----";
    private final String UNIT_EMPTY_BRIDGE_CHARACTOR = "     ";
    private final String NAME_FIXED_SIX_SPACE = "      ";

    public void showLadderGameResult(Users users, Ladder ladder) {
        System.out.println(PRINT_TEXT_RESULT);
        printUsers(users);
        printLadder(ladder);
    }

    private void printUsers(Users users) {
        List<User> userList = users.getUsers();

        String userNamesField = userList.stream()
                .map(user -> getFixedLengthUserName(user.getUserName()))
                .reduce("", (userNames, userName) -> userNames + userName);
        System.out.println(userNamesField);
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLadder();
        for (Line line : lines) {
            String lineString = line.getPoints().stream()
                    .map(point -> printBridge(point))
                    .collect(Collectors.joining(UNIT_LADDER_CHARACTOR, UNIT_LADDER_CHARACTOR, UNIT_LADDER_CHARACTOR));
            System.out.println(lineString);
        }
    }

    private String printBridge(boolean isBridge) {
        return isBridge ? UNIT_BRIDGE_CHARACTOR : UNIT_EMPTY_BRIDGE_CHARACTOR;
    }

    private String getFixedLengthUserName(String userName) {
        StringBuilder fixedLengthUserName = new StringBuilder();
        String newPrefix = NAME_FIXED_SIX_SPACE.substring(userName.length());
        fixedLengthUserName.append(userName).append(newPrefix);

        return fixedLengthUserName.toString();
    }
}
