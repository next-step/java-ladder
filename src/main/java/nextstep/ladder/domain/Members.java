package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Members {
    private static final String DEFAULT_WHITE_SPACE_CHARACTER = " ";
    private static final String DEFAULT_CHARACTER = "";
    private static final String DEFAULT_SPLIT_CHARACTER = ",";
    private static final int DEFAULT_MEMBER_NUMBER = 1;

    public final List<Member> members;

    public Members(String memberNames) {
        this.members = memberNames(memberNames);
    }

    public Members(List<Member> members) {
        this.members = members;
    }

    private List<Member> memberNames(String memberNames) {
        String[] splitMemberNames = memberNames.replaceAll(DEFAULT_WHITE_SPACE_CHARACTER, DEFAULT_CHARACTER)
                .split(DEFAULT_SPLIT_CHARACTER);
        validationNames(splitMemberNames);

        return Arrays.stream(splitMemberNames)
                            .map(name -> new Member(name))
                            .collect(Collectors.toList());
    }

    private void validationNames(String[] splitMemberNames) {
        if(splitMemberNames.length < DEFAULT_MEMBER_NUMBER){
            throw new IllegalArgumentException("참가자 수가 정확하지 않습니다.");
        }
    }

    public List<Member> getMembers() {
        return members;
    }
}
