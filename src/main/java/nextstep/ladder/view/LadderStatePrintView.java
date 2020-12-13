package nextstep.ladder.view;

import nextstep.ladder.domain.*;

public class LadderStatePrintView {

    private static final String FIVE_SIZE_STRING_LEFT_FORMATTER = "%-5s";
    private static final String FIVE_SIZE_STRING_RIGHT_FORMATTER = "%5s";
    private static final String BAR = "|";
    private static final String LEFT_BAR = "----|";

    public static void print(LadderGame ladderGame) {
        StringBuilder stringBuilder = new StringBuilder();
        Users users = ladderGame.getUsers();
        stringBuilder.append(buildUserNameString(users));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(buildLadderString(ladderGame.getLadder()));
        stringBuilder.append(buildLadGoalBoardString(ladderGame.getLadderGoalBoard()));
        System.out.println(stringBuilder);
    }

    private static String buildUserNameString(Users users) {
        StringBuilder sb = new StringBuilder();
        for (User user : users.export()) {
            sb.append(String.format(FIVE_SIZE_STRING_RIGHT_FORMATTER, user.getName()));
        }
        return sb.toString();
    }

    private static String buildLadderString(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        for (LadderRow ladderRow : ladder.getLadderRows()) {
            sb.append(buildLadderRowString(ladderRow));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static String buildLadderRowString(LadderRow ladderRow) {
        StringBuilder sb = new StringBuilder();
        for (LadderPoint ladderPoint : ladderRow.export()) {
            Direction direction = ladderPoint.getDirection();
            sb.append(buildDirection(direction));
        }
        return sb.toString();
    }

    private static String buildDirection(Direction direction) {
        if (direction.equals(Direction.NONE) || direction.equals(Direction.RIGHT)) {
            return String.format(FIVE_SIZE_STRING_RIGHT_FORMATTER, BAR);
        }
        return LEFT_BAR;
    }

    private static String buildLadGoalBoardString(LadderGoalBoard ladderGoalBoard) {
        StringBuilder sb = new StringBuilder();
        for (LadderGoal ladderGoal : ladderGoalBoard.export()) {
            sb.append(String.format(FIVE_SIZE_STRING_LEFT_FORMATTER, ladderGoal.getValue()));
        }
        return sb.toString();
    }
}
