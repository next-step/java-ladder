package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Links;

public class LadderPrinter {

    public static void print(Ladder ladder) {
        Links links = ladder.getLinks();


        for (int y = 0; y < links.getBoundY(); y++) {
            StringBuilder sb = new StringBuilder();
            sb.append("|");

            for (int x = 0; x < links.getBoundX(); x++) {
                boolean mark = links.getMark(x, y);
                if (mark) {
                    sb.append("---");
                } else {
                    sb.append("   ");
                }
                sb.append("|");
            }
            System.out.println(sb.toString());
        }
    }
}
