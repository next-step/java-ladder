package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public class LadderStatePrintView {


    public static void print(Ladder ladder) {
        Users users = ladder.getUsers();
        List<User> export = users.export();
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : export) {
            stringBuilder.append(String.format("%5s", user.getName()));
        }
        stringBuilder.append(System.lineSeparator());
        LadderRows ladderRows = ladder.getLadderRows();
        List<LadderRow> ladderRowList = ladderRows.getLadderRows();
        for (LadderRow ladderRow : ladderRowList) {
            for (LadderPoint ladderPoint : ladderRow.export()) {
                Direction direction = ladderPoint.getDirection();
                stringBuilder.append(buildDirection(direction));
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);

    }

    private static String buildDirection(Direction direction) {
        if (direction.equals(Direction.NONE) || direction.equals(Direction.RIGHT)) {
            return String.format("%5s", "|");
        }
        return "----|";
    }
}
