package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Member;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.Result;

import java.util.Scanner;

public class ResultView {

    private static final String PROMPT_GET_NAME = "결과를 보고 싶은 사람은?";
    private static final String ALL = "all";

    public static void printResult(Ladder ladder) {
        while(true) {
            String name = getNameForResult();
            if (ALL.equals(name)) {
                printResultAll(ladder);
                return;
            }
            Member member = ladder.getMembers().findMemberByName(name);
            printResultOfMember(ladder, member);
        }
    }

    public static String getNameForResult() {
        System.out.println(PROMPT_GET_NAME);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine().trim();
    }

    private static void printResultAll(Ladder ladder) {
        Members members = ladder.getMembers();
        members.getNames()
                .stream()
                .map(members::findMemberByName)
                .map(member -> String.format("%s : %s", member.getName(), ladder.getResultOf(member).getTitle()))
                .forEach(System.out::println);
    }

    private static void printResultOfMember(Ladder ladder, Member member) {
        Result result = ladder.getResultOf(member);
        System.out.println(result.getTitle());
    }
}
