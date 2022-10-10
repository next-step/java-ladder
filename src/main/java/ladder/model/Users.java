package ladder.model;


import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public static Users createUsersWithName(List<String> names) {
        return new Users(names.stream()
                .map(UserName::new)
                .map(User::new)
                .collect(Collectors.toList()));
    }

    public int size() {
        return this.users.size();
    }

    public void addLine(List<HorizontalLine> horizontalLine) {
        horizontalLine.forEach((line) -> line.validate(this.size()));
        for (int userIndex = 0; userIndex < this.users.size(); userIndex++) {
            users.get(userIndex).addLine(VerticalLine.mapHorizontalLineToVertical(horizontalLine, userIndex));
        }
    }

    public boolean hasLine() {
        return !this.users.stream().anyMatch(user -> !user.hasLine());
    }

    public List<User> getUsers() {
        return users;
    }
}
