package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.floor.Floor;
import nextstep.ladder.domain.floor.Floors;
import nextstep.ladder.domain.floor.Link;

import java.util.stream.Collectors;

public class LadderPrinter {

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_MARGIN = "    ";
    private static final String HORIZONTAL_LINK = "-----";
    private static final String HORIZONTAL_BLANK = "     ";

    public static void print(Ladder ladder) {

        printMemberNames(ladder.getMembers());

        Floors floors = ladder.getFloors();
        for (int i = 0; i < floors.getMaxHeight(); i++) {
            printFloor(floors.getFloor(i));
        }

        printResultTitles(ladder.getResults());
    }

    private static void printMemberNames(Members members) {
        String names = members.getNames()
                .stream()
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(" "));

        System.out.println(names);
    }

    private static void printResultTitles(Results results) {
        String titles = results.getTitles()
                .stream()
                .map(title -> String.format("%5s", title))
                .collect(Collectors.joining(" "));

        System.out.println(titles);
    }

    private static void printFloor(Floor floor) {
        int maxLinks = floor.getSizeOfLinks();
        StringBuilder sb = new StringBuilder();

        sb.append(HORIZONTAL_MARGIN);
        sb.append(VERTICAL_LINE);
        for (int x = 0; x < maxLinks; x++) {
            sb.append(printLink(floor.getLink(x)));
            sb.append(VERTICAL_LINE);
        }

        System.out.println(sb.toString());
    }

    private static String printLink(Link linked) {
        if (linked == Link.LINKED) {
            return HORIZONTAL_LINK;
        }
        return HORIZONTAL_BLANK;
    }
}
