package ladder.model;


import java.util.*;

public class LadderResult {

    private final Map<User, Prize> result;

    public LadderResult(List<User> users, List<Prize> prizes) {
        validateLadderResult(users, prizes);
        result = new LinkedHashMap<>();

        for (int i = 0; i < users.size(); i++) {
            result.put(users.get(i), prizes.get(i));
        }
    }

    private void validateLadderResult(List<User> users, List<Prize> prizes) {
        if (users.size() != prizes.size()) {
            throw new IllegalArgumentException("유저와 경품 갯수가 다릅니다.");
        }
    }

    public Prize getPrizeByUser(User user) {
        validateUser(user);
        return result.get(user);
    }

    private void validateUser(User user) {
        if (!result.containsKey(user)) {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
    }

}
