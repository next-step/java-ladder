package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderMembers {
    private static final int MINIMUM_MEMBERS_SIZE = 2;
    private static final String SEPARATOR = ",";
    private static final String INPUT_MEMBERS_NAME_EXCEPTION_MESSAGE = "사람의 이름을 입력하지 않아 사다리 게임을 시작할 수 없습니다. 다시 입력을 해주세요.";
    private static final String MEMBERS_SIZE_MESSAGE = MINIMUM_MEMBERS_SIZE + "명 이상의 이름을 입력해야 합니다. (" + SEPARATOR + "로 구분합니다.)";

    private final List<LadderMember> members;

    public LadderMembers(String gameMembers) {
        this(toMembers(checkNull(gameMembers)));
    }

    public LadderMembers(List<LadderMember> members) {
        checkSize(members);
        this.members = members;
    }

    public static List<LadderMember> toMembers(String gameMembers) {
        return Stream.of(gameMembers.split(SEPARATOR))
                .map(LadderMember::new)
                .collect(Collectors.toList());
    }

    private static String checkNull(String gameMembers) {
        if (gameMembers == null || gameMembers.isBlank()) {
            throw new IllegalArgumentException(INPUT_MEMBERS_NAME_EXCEPTION_MESSAGE);
        }
        return gameMembers;
    }

    private static void checkSize(List<LadderMember> members) {
        if (members.size() < MINIMUM_MEMBERS_SIZE) {
            throw new IllegalArgumentException(MEMBERS_SIZE_MESSAGE);
        }
    }

    public int memberCount() {
        return members.size();
    }

    public List<LadderMember> getMembers() {
        return members;
    }
}
