package ladder.domain;

import ladder.domain.prize.Prize;
import ladder.domain.user.User;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGameResult {
    private Map<User, Prize> result = new LinkedHashMap<>();

    public void put(final User user, final Prize prize) {
        result.put(user, prize);
    }

    public int size() {
        return result.size();
    }

    public Map<String, String> toDTO() {
        final Map<String, String> dto = new LinkedHashMap<>();
        for (final User user : result.keySet()) {
            final Prize prize = result.get(user);
            dto.put(user.getName(), prize.getName());
        }
        return dto;
    }
}
