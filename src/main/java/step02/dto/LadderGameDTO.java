package step02.dto;

import step02.ladder.Ladder;
import step02.user.Users;

public class LadderGameDTO {
    private final Ladder ladder;
    private final Users users;

    public LadderGameDTO(Ladder ladder, Users users) {
        this.ladder = ladder;
        this.users = users;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Users getUsers() {
        return users;
    }
}
