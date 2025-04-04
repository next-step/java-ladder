package laddergame.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Users {
    public static final String DELIMETER = ",";

    private final List<User> users;
    private final List<String> results;

    public Users(String nameString, String resultString) {
        users = new ArrayList<>();
        List<String> names = Arrays.asList(nameString.split(DELIMETER));
        for (String name: names) {
            users.add(new User(name));
        }
        results = Arrays.asList(resultString.split(DELIMETER));
        validate();
    }

    private void validate() {
        if (users.size() != results.size()) {
            throw new IllegalArgumentException("참여하는 사람의 수와 실행 결과의 개수가 맞지 않습니다.");
        }
    }

    public int getUserCount() {
        return users.size();
    }

    public List<Name> getUserNames() {
        return users.stream()
                .map(user -> user.getName())
                .collect(Collectors.toList());
    }

    public List<String> getResults() {
        return results;
    }

    public Map<User, String> makeGameResult(Map<Integer, Integer> ladderResult) {
        Map<User, String> gameResult = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> result: ladderResult.entrySet()) {
            gameResult.put(users.get(result.getKey()), results.get(result.getValue()));
        }
        return gameResult;
    }
}
