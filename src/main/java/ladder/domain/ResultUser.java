package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultUser {
    private final Map<User, String> result;

    public ResultUser(Map<User, String> result) {
        this.result = result;
    }

    public static ResultUser of(Ladder ladder, ResultInput resultInput) {
        List<String> userNames = ladder.getUserNames();
        List<Integer> positions = ladder.climbAll();
        if (userNames.size() != resultInput.size()) {
            throw new IllegalArgumentException("사용자 수와 결과 수가 일치하지 않습니다.");
        }
        return new ResultUser(
                IntStream.range(0, userNames.size())
                        .boxed()
                        .collect(Collectors.toMap(
                                i -> new User(userNames.get(i)),
                                i -> resultInput.getResultByPosition(positions.get(i))
                        ))
        );
    }

    public List<String> getUserNames() {
        return result.keySet().stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public String getResultByUser(User user) {
        return result.get(user);
    }

    public String getResultByUser(String userName) {
        return getResultByUser(new User(userName));
    }
}
