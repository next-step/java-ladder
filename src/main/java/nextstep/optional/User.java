package nextstep.optional;

import java.util.Objects;
import java.util.Optional;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean matchName(String name) {
        return this.name.equals(name);
    }

    public static boolean ageIsInRange1(User user) {
        if (Objects.isNull(user)) {
            return false;
        }
        return user.isMiddleRange();
    }

    public static Optional<User> ageIsInRange2(User user) {
        Optional<User> optionalUser = Optional.ofNullable(user);

        return optionalUser.filter(User::isMiddleRange);
    }

    private boolean isMiddleRange() {
        return age >= 30 && age <= 45;
    }

    @Override
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
        User user = (User) compareValue;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
