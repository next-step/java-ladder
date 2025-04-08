package laddergame.domain.user;

import java.util.*;

public class Users {
    public static final String DELIMETER = ",";

    private Names users;
    private final List<String> results;

    public Users(String nameString, String resultString) {
        this.users = new Names(nameString.split(DELIMETER));
        this.results = Arrays.asList(resultString.split(DELIMETER));
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
        return users.getNames();
    }

    public List<String> getResults() {
        return results;
    }

    public Map<Name, String> makeGameResult(Map<Integer, Integer> ladderResult) {
        Map<Name, String> gameResult = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> result: ladderResult.entrySet()) {
            gameResult.put(users.getNames().get(result.getKey()), results.get(result.getValue()));
        }
        return gameResult;
    }
}
