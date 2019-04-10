package ladder.parser;

import ladder.domain.member.Member;
import ladder.domain.member.MemberGroup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemberParser {
    private static final String SEPARATOR = ",";

    private MemberParser() {
    }

    public static MemberGroup parseMemberGroup(String memberNames) {
        return new MemberGroup(parseMembers(memberNames));
    }

    public static Member parseMember(String name) {
        return new Member(name.trim());
    }

    private static List<Member> parseMembers(String members) {
        return Arrays.stream(members.split(SEPARATOR))
                .map(MemberParser::parseMember)
                .collect(Collectors.toList());
    }
}
