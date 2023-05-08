package nextstep.optional;

import java.util.Objects;
import java.util.Optional;

public class User {
    private static final int MINIMUM_AGE = 30;
    private static final int MAXIMUM_AGE = 45;

    private final String name;
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean matchName(String name) {
        return this.name.equals(name);
    }

    public static boolean ageIsInRange1(User user) {
        return passCondition(user);
    }

    private static boolean passCondition(User user) {

        if (Objects.isNull(user)) {
            return false;
        }

        if (Objects.isNull(user.getAge())) {
            return false;
        }

        return user.getAge() >= MINIMUM_AGE && user.getAge() <= MAXIMUM_AGE;
    }

    public static boolean ageIsInRange2(User user) {
        return Optional.ofNullable(user)
                .filter(user1 -> passCondition(user))
                .isPresent();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
