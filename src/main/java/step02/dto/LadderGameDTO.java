package step02.dto;

import step02.ladder.Ladder;
import step02.user.Users;

public class LadderGameDTO {
    private Ladder ladder;
    private Users users;

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }
}
