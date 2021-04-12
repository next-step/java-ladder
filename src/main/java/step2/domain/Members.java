package step2.domain;

import step2.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Members {
    private static final String DEFAULT_REGEX = ",";
    private static final int MIN_MEMBER_COUNT = 2;
    public static final String MEMBERS_MIN_SIZE_TWO_EXCEPTION_MESSAGE = "두 명 이상의 사용자가 참여해야 합니다.";

    private final List<Member> members;

    private Members(List<Member> members) {
        this.members = members;
    }

    public static Members of(String paramNames) {
        validationNames(paramNames);
        String[] names = paramNames.split(DEFAULT_REGEX);
        validationMembers(names);

        List<Member> members = Arrays.stream(names)
                .map(Member::new)
                .collect(Collectors.toList());

        return new Members(members);
    }

    private static void validationNames(String paramNames) {
        if (StringUtils.isEmpty(paramNames)) {
            throw new IllegalArgumentException(Member.INPUT_NAME_EXCEPTION_MESSAGE);
        }
    }

    private static void validationMembers(String[] paramNames) {
        if (paramNames.length < MIN_MEMBER_COUNT) {
            throw new IllegalArgumentException(MEMBERS_MIN_SIZE_TWO_EXCEPTION_MESSAGE);
        }
    }

    public int getSize() {
        return members.size();
    }

    public List<String> getNames() {
        return members.stream()
                .map(Member::getName)
                .collect(Collectors.toList());
    }
}
