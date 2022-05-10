package nextstep.optional;

import java.util.Optional;

public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static boolean ageIsInRange1(User user) {
        return user != null && ageNotNull(user)
                && (ageOver29(user)
                && ageUnder46(user));
    }

    public static boolean ageIsInRange2(User user) {
        return Optional.ofNullable(user)
                .filter(User::ageNotNull)
                .map(User::getAge)
                .filter(User::ageOver29)
                .filter(User::ageUnder46)
                .isPresent();
    }

    private static boolean ageUnder46(Integer age) {
        return age <= 45;
    }

    private static boolean ageOver29(Integer age) {
        return age >= 30;
    }

    private static boolean ageUnder46(User user) {
        return ageUnder46(user.getAge());
    }

    private static boolean ageOver29(User user) {
        return user.getAge() >= 30;
    }

    private static boolean ageNotNull(User user) {
        return user.getAge() != null;
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
