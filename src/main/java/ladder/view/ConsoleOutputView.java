package ladder.view;

import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView {
    private ConsoleOutputView() {
    }

    public static void printMemberGroup(MemberGroup memberGroup) {
        System.out.println(getMemberGroupString(memberGroup));
    }

    static String getMemberGroupString(MemberGroup memberGroup) {
        List<Member> members = memberGroup.getMembers();
        String whiteSpace = getMaxWhiteSpace(members);

        return members.stream()
                .map(Member::toString)
                .collect(Collectors.joining(whiteSpace));
    }

    private static String getMaxWhiteSpace(List<Member> members) {
        StringBuilder whiteSpace = new StringBuilder();
        int maxNameLength = getMaxNameLengthOfMembers(members);

        for (int i = 0; i < maxNameLength; i++) {
            whiteSpace.append(" ");
        }

        return whiteSpace.toString();
    }

    private static int getMaxNameLengthOfMembers(List<Member> members) {
        return members.stream()
                .mapToInt(member -> {
                    String name = member.toString();
                    return name.length();
                })
                .max()
                .getAsInt();
    }
}
