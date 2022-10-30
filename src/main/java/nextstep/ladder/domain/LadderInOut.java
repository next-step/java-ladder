package nextstep.ladder.domain;

import java.util.List;

public class LadderInOut {
    private final List<String> results;

    private final Users users;

    public LadderInOut(List<String> results, Users users) {
        this.results = results;
        this.users = users;
    }

    public int indexOfUser(String name) {
        return users.indexOfUser(name);
    }

    public String getResult(int idx) {
        return results.get(idx);
    }

    public String getUserName(int idx) {
        return users.getUserName(idx);
    }

    public int getCountOfUser() {
        return users.getCountOfUser();
    }
}
