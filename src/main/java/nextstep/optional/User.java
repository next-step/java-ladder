package nextstep.optional;

import java.util.Optional;

public class User {
    private final String name;
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static boolean ageIsInRange1(User user) {
        return user != null && ageNotNull(user)
                && (ageSameOrOver30(user)
                && ageSameOrUnder45(user));
    }

    public static boolean ageIsInRange2(User user) {
        return Optional.ofNullable(user)
                .filter(User::ageNotNull)
                .map(User::getAge)
                .filter(User::ageSameOrOver30)
                .filter(User::ageSameOrUnder45)
                .isPresent();
    }

    private static boolean ageSameOrUnder45(Integer age) {
        return age <= 45;
    }

    private static boolean ageSameOrOver30(Integer age) {
        return age >= 30;
    }

    private static boolean ageSameOrUnder45(User user) {
        return ageSameOrUnder45(user.getAge());
    }

    private static boolean ageSameOrOver30(User user) {
        return user.getAge() >= 30;
    }

    private static boolean ageNotNull(User user) {
        return user.getAge() != null;
    }

    public Integer getAge() {
        return age;
    }

    public boolean matchName(String name) {
        return this.name.equals(name);
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
