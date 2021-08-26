package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Users implements Iterable<User> {
    private List<User> userList;

    public Users(String[] userName) {
        createUsers(userName);
    }

    public Users(List<User> userList) {
        this.userList = userList;
    }

    public int count() {
        return this.userList.size();
    }

    public void checkDuplicateUser() {
        long checkDistinctUserCount = this.userList.stream().map(User::name).distinct().count();
        if (checkDistinctUserCount != userList.size()) {
            throw new IllegalArgumentException("중복된 User가 있습니다.");
        }
    }

    public List<User> userList() {
        return this.userList;
    }

    public User findByName(String name) {
        return this.userList.stream()
                .filter(user -> user.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이름에 맞는 User가 없습니다."));
    }

    public User user(int index) {
        return userList.get(index);
    }

    public String[] userNames() {
        String[] userNames = new String[this.count()];

        for (int i = 0; i < this.count(); i++) {
            userNames[i] = user(i).name();
        }
        return userNames;
    }

    private void createUsers(String[] userNames) {
        userList = new ArrayList<>();
        AtomicInteger userOfInitIndex = new AtomicInteger();
        Arrays.stream(userNames).forEachOrdered(username -> {
            User newUser = new User(username, userOfInitIndex.getAndIncrement() * 2);
            userList.add(newUser);
        });
    }

    @Override
    public Iterator<User> iterator() {
        return this.userList.iterator();
    }
}
