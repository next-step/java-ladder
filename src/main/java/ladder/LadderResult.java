package ladder;

import ladder.name.Name;
import ladder.name.Names;

import java.util.*;

import static ladder.LadderGame.EXIT;

public class LadderResult {
    private static final String ALL = "all";

    private final Map<String, Position> ladderResultMap = new LinkedHashMap<>();

    public LadderResult(Names names, List<Position> ladderResult) {
        if (names.hasDifferentSize(ladderResult.size())) {
            throw new IllegalArgumentException("게임 참가자와 실행 결과의 수가 일치 하지 않습니다.");
        }

        for (int person = 0; person < names.getSize(); person++) {
            ladderResultMap.put(names.getNameOf(person), ladderResult.get(person));
        }
    }

    public Map<String, String> getBettingResult(Name user, Bettings bettings) {
        Map<String, String> userBettingResult = new HashMap<>();

        Optional<Map.Entry<String, Position>> userResult = ladderResultMap.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(user.getName()))
                .findFirst();

        if (userResult.isPresent()) {
            userBettingResult.put(userResult.get().getKey(), bettings.getBetting(userResult.get().getValue().getPosition()));
            return userBettingResult;
        }

        if (user.isNotEqualTo(ALL) && user.isNotEqualTo(EXIT)) {
            throw new IllegalArgumentException("잘못된 이름을 입력하였습니다.");
        }

        ladderResultMap.forEach((key, value) -> userBettingResult.put(key, bettings.getBetting(value.getPosition())));
        return userBettingResult;
    }
}
