package ladder.domain;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {

    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public static Users createUsersWithName(List<String> names) {
       return new Users(IntStream.range(0,names.size())
                .mapToObj((idx)-> User.withNameAndPosition(new UserName(names.get(idx)),new HorizontalPosition(idx)))
                .collect(Collectors.toList()));
    }

    public List<UserName> allUserName() {
        return this.users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public int size() {
        return this.users.size();
    }


    public User findUserByUsername(UserName name) {
        return this.users.stream()
                .filter((user)->user.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

    }

    public User findUserByPosition(HorizontalPosition position){
        return this.users.stream()
                .filter((user)->user.isSamePosition(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
    }

    public List<User> getUsers() {
        return users;
    }
}
