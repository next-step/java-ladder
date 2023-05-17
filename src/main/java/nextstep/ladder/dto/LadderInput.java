package nextstep.ladder.dto;

import java.util.List;

public class LadderInput {
    List<String> users;
    int height;

    public LadderInput(List<String> users, int height) {
        this.users = users;
        this.height = height;
    }

    public List<String> getUsers() {
        return users;
    }

    public int getHeight() {
        return height;
    }

    public int getUsersSize() {
        return users.size();
    }
}
