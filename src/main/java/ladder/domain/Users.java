package ladder.domain;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {

    private final Map<Position, User> users = new HashMap<>();

    public Users(List<User> users) {
        IntStream.range(0, users.size())
                .forEach((idx) -> this.users.put(new Position(idx), users.get(idx)));
    }

    public Users(User... users) {
        this(Arrays.stream(users)
                .collect(Collectors.toList()));
    }

    public Users() {
    }

    public static Users createUsersWithName(List<String> names) {
        return new Users(names.stream()
                .map(User::new)
                .collect(Collectors.toList()));
    }

    public List<UserName> findAllUsernames() {
        return this.users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public List<Position> findUserPositionByUsernames(List<UserName> names) {
        return names.stream()
                .map(this::findPositionByUsername)
                .collect(Collectors.toList());
    }

    private Position findPositionByUsername(UserName name) {
        return this.users.entrySet()
                .stream()
                .filter((entry) -> entry.getValue().isSameName(name))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

    }


    public User findUserByPosition(Position position) {
        return users.get(position);
    }

    public int size() {
        return this.users.size();
    }

    public void add(Position position, User user) {
        this.users.put(position, user);
    }
}
