package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Member;
import nextstep.ladder.domain.Members;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String RESPONSE_INIT_MESSAGE = "실행결과";
    private static final String RESPONSE_MEMBER_MESSAGE = "%5s";
    private static final String DEFAULT_WHITE_SPACE_CHARACTER = " ";
    private static final String NOT_LINKED_LINE = "     |";
    private static final String LINKED_LINE = "-----|";

    public static void responseInitMessage() {
        System.out.println();
        System.out.println(RESPONSE_INIT_MESSAGE);
    }

    public static void responseLadderMembers(Members members) {
        System.out.println();
        members.getMembers().stream()
                    .map(member -> rightAlignment(member.getName()) + DEFAULT_WHITE_SPACE_CHARACTER)
                    .forEach(System.out::print);
    }

    private static String rightAlignment(String text) {
        return String.format(RESPONSE_MEMBER_MESSAGE, text);
    }

    public static void responseLadder(Ladder ladder) {
        System.out.println();
        System.out.println(ladder);
    }
}
