package ladder.model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


    public List<Integer> findStartPositionByUsername(UserName name) {
        if (name.isAllUser()){
            return IntStream.range(0,this.size())
                    .mapToObj((i)->i)
                    .collect(Collectors.toList());
        }
        return List.of(IntStream.range(0, this.size())
                .filter((idx) -> this.users.get(idx).equals(new User(name)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다.")));
    }
    public List<User> getUsers() {
        return users;
    }
}
