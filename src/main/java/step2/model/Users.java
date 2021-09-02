package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static step2.model.LadderValidator.isBlank;

public class Users  {
    private static final int MIN_NUMBER_OF_USER = 1;

    private List<User> users;

    public Users(String usersName) {
        isBlank(usersName);
        isOverMinNumberOfUser(usersName);
        setUsersName(usersName);
    }

    private void setUsersName(String usersName) {
        this.users = new ArrayList<>();

        String[] names = usersName.split(",");

        for (String name : names) {
            this.users.add(new User(name));
        }
    }

    private void isOverMinNumberOfUser(String usersName) {
        String[] names = usersName.split(",");

        if (names.length < MIN_NUMBER_OF_USER) {
            throw new IllegalArgumentException("최소 한명 이상의 참가자를 입력해주세요");
        }
    }

    public int getNumberOfUsers() {
        return this.users.size();
    }

    public List<String> getName() {
        return users.stream()
                        .map(User::getName)
                        .collect(Collectors.toList());
    }

    public User getUser(int index) {
        return users.get(index);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
