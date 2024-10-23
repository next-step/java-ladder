package ladder;

import ladder.name.Name;
import ladder.name.Names;

import java.util.*;

import static ladder.LadderGame.EXIT;

public class LadderResult {
    private static final String ALL = "all";

    private final List<UserResult> userResults = new ArrayList<>();

    public LadderResult(Names names, List<Position> ladderResult) {
        if (names.hasDifferentSize(ladderResult.size())) {
            throw new IllegalArgumentException("게임 참가자와 실행 결과의 수가 일치 하지 않습니다.");
        }

        for (int person = 0; person < names.getSize(); person++) {
            userResults.add(new UserResult(names.getName(person), ladderResult.get(person)));
        }
    }

    public Map<String, String> getBettingResult(Name user, Bettings bettings) {
        Map<String, String> userBettingResult = new HashMap<>();

        UserResult foundUserResult = userResults.stream()
                .filter(userResult -> userResult.isNameEqualTo(user))
                .findFirst()
                .orElse(null);

        if (Objects.nonNull(foundUserResult)) {
            userBettingResult.put(foundUserResult.getName(),
                    bettings.getBetting(foundUserResult.getPosition()));
            return userBettingResult;
        }

        if (user.isNotEqualTo(ALL) && user.isNotEqualTo(EXIT)) {
            throw new IllegalArgumentException("잘못된 이름을 입력하였습니다.");
        }

        userResults.forEach(userResult ->
                userBettingResult.put(userResult.getName(), bettings.getBetting(userResult.getPosition())
        ));
        return userBettingResult;
    }
}
