package ladder.domain;

public class Ladder {

    private final Users users;
    private final Lines lines;

    private Ladder(Users users, Lines lines) {
        this.users = users;
        this.lines = lines;
    }

    public static Ladder of(Users users, Lines lines) {
        return new Ladder(users, lines);
    }

    public Lines getLines() {
        return lines;
    }

    public Users getUsers() {
        return users;
    }

    public int getUserCount() {
        return users.countOfPerson();
    }

    public User getUser(int index) {
        return users.getUser(index);
    }

    public int getFinalPosition(int index) {
        return lines.getFinalPosition(index);
    }
}
