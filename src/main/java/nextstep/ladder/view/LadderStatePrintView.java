package nextstep.ladder.view;

import nextstep.ladder.domain.*;

public class LadderStatePrintView {

    private static final String FIVE_SIZE_STRING_LEFT_FORMATTER = "%-5s";
    private static final String FIVE_SIZE_STRING_RIGHT_FORMATTER = "%5s";
    private static final String BAR = "|";
    private static final String LEFT_BAR = "----|";

    public static void print(Ladder ladder, Users users, LadderGoals ladderGoals) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(buildUserNameString(users));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(buildLadderString(ladder));
        stringBuilder.append(buildLadGoalBoardString(ladderGoals));
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

    private static String buildLadGoalBoardString(LadderGoals ladderGoals) {
        StringBuilder sb = new StringBuilder();
        for (LadderGoal ladderGoal : ladderGoals.export()) {
            sb.append(String.format(FIVE_SIZE_STRING_LEFT_FORMATTER, ladderGoal.getValue()));
        }
        return sb.toString();
    }
}
