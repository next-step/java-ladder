package nextstep.ladder.domain;

public class LadderDto {

    private final Users users;
    private final Ladder ladder;

    public LadderDto(Users users, LadderHeight height) {
        this.users = users;
        this.ladder = new Ladder(users, height);
    }

    public Users getUsers() {
        return users;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
