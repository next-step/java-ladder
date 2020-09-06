package nextstep.ladder.domain.result;


import nextstep.ladder.domain.user.User;
import nextstep.ladder.view.ResultView;

import java.util.*;

import static nextstep.ladder.utils.CommonConstant.NUMBER_ZERO;
import static nextstep.ladder.utils.LadderValidation.INVALID_USER;

public class LadderResult {

    private Map<User, Integer> ladderResult;

    public LadderResult(List<User> users) {
        this.ladderResult = initMap(users);
    }

    private Map<User, Integer> initMap(List<User> users) {
        ladderResult = new HashMap<>();
        for (int i = NUMBER_ZERO; i < users.size(); i++) {
            User user = users.get(i);
            ladderResult.put(user, i);
        }
        return ladderResult;
    }

    public static String maybeUserResult(String gameResult, Map<User, Integer> ladderResult, List<String> result) {
        return Optional.ofNullable(new User(gameResult))
                .filter(ladderResult::containsKey)
                .map(position -> ladderResult.get(position))
                .map(result::get)
                .orElseThrow(() -> new IllegalArgumentException(INVALID_USER));
    }

    public Map<User, Integer> getLadderResult() {
        return ladderResult;
    }

}
