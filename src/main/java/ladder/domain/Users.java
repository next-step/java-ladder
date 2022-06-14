package ladder.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Users {
    private List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public int size() {
        return this.users.size();
    }

    public String findName(int index) {
        return this.users.get(index).getName();
    }

    public static Users userGenerate(String commaNames) {
        AtomicInteger index = new AtomicInteger();

        Users users = new Users(stream(commaNames.split(","))
                .map(name -> new User(name, index.getAndIncrement()))
                .collect(Collectors.toList()));

        return users;

    }

    public void drawUserNames() {
        for (User user : users) {
            System.out.print(user.getName() + " ");
        }
    }
}
