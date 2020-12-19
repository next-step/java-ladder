package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.floor.Floor;

import java.util.stream.Collectors;

public class LadderPrinter {

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_MARGIN = "    ";
    private static final String HORIZONTAL_LINK = "-----";
    private static final String HORIZONTAL_BLANK = "     ";

    public static void print(Ladder ladder) {

        printMemberNames(ladder.getMembers());

        for (Floor floor : ladder.getFloors()) {
            printFloor(floor);
        }
    }

    private static void printMemberNames(Members members) {
        String names = members.getNames()
                .stream()
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(" "));

        System.out.println(names);
    }

    private static void printFloor(Floor floor) {
        int maxLinks = floor.getMaxLinks();
        StringBuilder sb = new StringBuilder();

        sb.append(HORIZONTAL_MARGIN);
        sb.append(VERTICAL_LINE);
        for (int x = 0; x < maxLinks; x++) {
            sb.append(printLink(floor.getLinked(x)));
            sb.append(VERTICAL_LINE);
        }

        System.out.println(sb.toString());
    }

    private static String printLink(boolean isLinked) {
        if (isLinked) {
            return HORIZONTAL_LINK;
        }
        return HORIZONTAL_BLANK;
    }
}
