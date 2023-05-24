package nextstep.ladder.dto;

import java.util.List;

public class LadderInput {
    List<String> users;
    List<String> results;
    int height;

    public LadderInput(List<String> users, int height, List<String> results) {
        this.users = users;
        this.height = height;
        this.results = results;
    }

    public List<String> getUsers() {
        return users;
    }

    public int getHeight() {
        return height;
    }

    public List<String> getResults() {
        return results;
    }

    public int getUsersSize() {
        return users.size();
    }
}
