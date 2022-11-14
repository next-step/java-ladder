package ladder.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final Users users;
    private final Ladder ladder;

    private static final Map<String, String> resultCache = new HashMap<>();

    public LadderGame(Users users, Ladder ladder, List<String> results) {
        validateSize(users, ladder, results);
        play(users, ladder, results);

        this.users = users;
        this.ladder = ladder;
    }

    private static void validateSize(Users users, Ladder ladder, List<String> results) {
        if (users.size() != results.size()) {
            throw new IllegalArgumentException("유저 수와 결과 수가 맞지 않습니다.");
        }

        if (users.size() != ladder.getWidth()) {
            throw new IllegalArgumentException("유저 수와 사다리 넓이가 같지 않습니다.");
        }
    }

    private void play(Users users, Ladder ladder, List<String> results) {
        IntStream.range(0, users.size())
                .boxed()
                .forEach(i -> {
                    int resultIndex = ladder.arriveAt(i);
                    resultCache.put(users.getUser(i).getName(), results.get(resultIndex));
                });
    }

    public String getResult(String name) {
        if (!resultCache.containsKey(name)) {
            throw new NoSuchElementException("해당 유저는 존재하지 않습니다. 입력값: " + name);
        }
        return resultCache.get(name);
    }

    public List<String> getResults() {
        return users.stream()
                .map(user -> resultCache.get(user.getName()))
                .collect(Collectors.toList());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Users getUsers() {
        return users;
    }
}
