package step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class UserList implements Iterable<User>{

    private List<User> userList;

    private UserList(List<User> userList) {
        this.userList = userList;
    }

    public static UserList create(String userNameList) {
        if (Objects.isNull(userNameList)) {
            throw new IllegalArgumentException("유저 이름 리스트는 필수값 입니다.");
        }

        return  Arrays.asList(userNameList.split(","))
                .stream()
                .map(User::valueOf)
                .collect(Collectors.collectingAndThen(toList(), UserList::new));
    }

    public int getTotalParticipantsCount() {
        return userList.size();
    }

    public Stream<User> stream() {
        return userList.stream();
    }

    @Override
    public Iterator<User> iterator() {
        return userList.iterator();
    }
}
