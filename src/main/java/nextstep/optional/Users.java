package nextstep.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Users {
    static final User DEFAULT_USER = new User("codesquad", 100);

    List<User> users = Arrays.asList(
            new User("crong", 35),
            new User("pobi", 30),
            new User("jk", 40),
            new User("honux", 45));

    /**
     nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.
     자바 8의 stream과 Optional을 사용하도록 리팩토링한 후 UsersTest의 단위 테스트가 통과해야 한다.

     힌트
     Guide To Java 8 Optional 문서를 참고해 Optional 사용 방법을 익힌다.
     Optional의 orElse() 메소드 활용해 구현한다.
     */
    User getUser(String name) {
        Optional<User> optionalUser = users.stream()
                .filter(user -> user.matchName(name))
                .findFirst();

        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        return optionalUser.orElse(DEFAULT_USER);

//        for (User user : users) {
//            if (user.matchName(name)) {
//                return user;
//            }
//        }
//        return DEFAULT_USER;
    }
}
