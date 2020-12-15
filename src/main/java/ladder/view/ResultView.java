package ladder.view;

import ladder.dto.LadderDTO;
import ladder.dto.RewardsDTO;
import ladder.dto.UsersDTO;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String LADDER_DESCRIPTION_MESSAGE = "사다리 결과";
    private static final String RESULT_OPENING_MESSAGE = "실행 결과";
    private static final String LADDER_PRINT_MARGIN = "     ";
    private static final String LADDER_DIVIDER = "|";
    private static final String IS_HORIZONTAL = "-----";
    private static final String IS_NOT_HORIZONTAL = "     ";

    private ResultView() {
    }

    public static void printLadderLayoutOpening() {
        System.out.println(LADDER_DESCRIPTION_MESSAGE);
    }

    public static void printUsers(UsersDTO usersDTO) {
        List<String> users = usersDTO.getUsers();
        for (String user : users) {
            System.out.printf("%6s", user);
        }
        System.out.println();
    }

    public static void printLadder(LadderDTO ladderDTO) {
        List<List<Boolean>> layout = ladderDTO.getLayout();
        for (List<Boolean> line : layout) {
            printLine(line);
        }
    }

    private static void printLine(List<Boolean> line) {
        System.out.print(LADDER_PRINT_MARGIN);
        for (Boolean status : line) {
            System.out.print(LADDER_DIVIDER);
            printPart(status);
        }
        System.out.println(LADDER_DIVIDER);
    }

    private static void printPart(Boolean status) {
        String part = status ? IS_HORIZONTAL : IS_NOT_HORIZONTAL;
        System.out.print(part);
    }

    public static void printRewards(RewardsDTO rewardsDTO) {
        List<String> rewards = rewardsDTO.getRewards();
        for (String reward : rewards) {
            System.out.printf("%6s", reward);
        }
        System.out.println();
    }

    public static void printRewardsOpening() {
        System.out.println(RESULT_OPENING_MESSAGE);
    }

    public static void printAll(Map<String, String> mapper) {
        for (String key : mapper.keySet()) {
            System.out.println(key + ":" + mapper.get(key));
        }
    }

    public static void printForOne(String reward) {
        System.out.println(reward);
    }
}
