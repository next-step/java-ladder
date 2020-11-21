package nextstep.ladder;

import nextstep.ladder.domain.member.Members;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameResult {
    private final LinkedHashMap<String, String> endPointsOfMembers;

    private LadderGameResult(LinkedHashMap<String, String> endPointsOfMembers) {
        this.endPointsOfMembers = endPointsOfMembers;
    }

    public static LadderGameResult of(Members members, List<String> endPointsOfMembersPosition) {
        return new LadderGameResult(getEndPointsOfMembers(members, endPointsOfMembersPosition));
    }

    private static LinkedHashMap<String, String> getEndPointsOfMembers(Members members, List<String> endPointsOfMembersPosition) {
        return IntStream.range(0, endPointsOfMembersPosition.size())
                .boxed()
                .collect(Collectors.toMap(members::getMemberNameAtPosition, endPointsOfMembersPosition::get, (x, y) -> y, LinkedHashMap::new));
    }

    public static LadderGameResult of(LinkedHashMap<String, String> endPointsOfMembers) {
        return new LadderGameResult(endPointsOfMembers);
    }

    public Optional<String> getEndPointOfMemberIfExist(String memberName) {
        return Optional.ofNullable(endPointsOfMembers.get(memberName));
    }

    public Map<String, String> getAll() {
        return Collections.unmodifiableMap(endPointsOfMembers);
    }
}
