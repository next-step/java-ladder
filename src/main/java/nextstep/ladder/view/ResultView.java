package nextstep.ladder.view;

import java.util.Scanner;

public class ResultView {
    private static final Scanner sc = new Scanner(System.in);
    private static final String HEIGHT_BAR = "|";
    private static final String SPACE_LINE = "    ";
    private static final String BRIDGE_LINE = "-----";

    public static void resultJoinMember(String member){
        System.out.println(member);
    }
}
