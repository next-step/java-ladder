package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public class LadderStatePrintView {

    private static final String FIVE_SIZE_STRING_FORMATTER = "%5s";
    private static final String BAR = "|";
    private static final String LEFT_BAR = "----|";

    public static void print(Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        Users users = ladder.getUsers();
        stringBuilder.append(buildUserNameString(users));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(buildLadderString(ladder));
        System.out.println(stringBuilder);
    }

    private static String buildUserNameString(Users users) {
        StringBuilder sb = new StringBuilder();
        for (User user : users.export()) {
            sb.append(String.format(FIVE_SIZE_STRING_FORMATTER, user.getName()));
        }
        return sb.toString();
    }

    private static String buildLadderString(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        LadderRows ladderRows = ladder.getLadderRows();
        List<LadderRow> ladderRowList = ladderRows.getLadderRows();
        for (LadderRow ladderRow : ladderRowList) {
            for (LadderPoint ladderPoint : ladderRow.export()) {
                Direction direction = ladderPoint.getDirection();
                sb.append(buildDirection(direction));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static String buildDirection(Direction direction) {
        if (direction.equals(Direction.NONE) || direction.equals(Direction.RIGHT)) {
            return String.format(FIVE_SIZE_STRING_FORMATTER, BAR);
        }
        return LEFT_BAR;
    }
}
