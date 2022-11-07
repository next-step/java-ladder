package ladder.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderMembersExpression {
    private static final String SEPARATOR = ",";
    private static final String INPUT_MEMBERS_NAME_EXCEPTION_MESSAGE = "사람의 이름을 입력하지 않아 사다리 게임을 시작할 수 없습니다. 다시 입력을 해주세요.";

    private LadderMembersExpression() {
    }

    public static List<String> validateMemberNames(String gameMembers) {
        checkNull(gameMembers);
        return toStrings(gameMembers);
    }

    private static List<String> toStrings(String gameMembers) {
        return Stream.of(gameMembers.split(SEPARATOR))
                .collect(Collectors.toList());
    }

    private static void checkNull(String gameMembers) {
        if (gameMembers == null || gameMembers.isBlank()) {
            throw new IllegalArgumentException(INPUT_MEMBERS_NAME_EXCEPTION_MESSAGE);
        }
    }
}
