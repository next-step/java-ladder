package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderMembers {
    private static final int MINIMUM_MEMBERS_SIZE = 2;
    private static final String MEMBERS_SIZE_MESSAGE = MINIMUM_MEMBERS_SIZE + "명 이상의 이름을 입력해야 합니다.";

    private final List<LadderMember> members;

    public LadderMembers(List<LadderMember> members) {
        checkSize(members);
        this.members = members;
    }

    public static List<LadderMember> addMember(List<String> gameMembers) {
        return gameMembers.stream()
                .map(LadderMember::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public LadderMember findByMember(int memberIndex) {
        return IntStream.range(memberIndex, memberIndex + 1)
                .mapToObj(members::get)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 member가 없습니다."));
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
