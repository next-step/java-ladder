package laddergame.domain.user;

import java.util.*;

public class Users {
    public static final String DELIMETER = ",";

    private Names users;
    private final Results results;

    public Users(String nameString, String resultString) {
        this.users = new Names(nameString.split(DELIMETER));
        this.results = new Results(resultString, users.size());
    }

    public int getUserCount() {
        return users.size();
    }

    public List<Name> getUserNames() {
        return users.getNames();
    }

    public List<String> getResults() {
        return results.getResults();
    }

    public Map<Name, String> makeGameResult(Map<Integer, Integer> ladderResult) {
        Map<Name, String> gameResult = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> result: ladderResult.entrySet()) {
            gameResult.put(users.getNames().get(result.getKey()), results.getResult(result.getValue()));
        }
        return gameResult;
    }
}
