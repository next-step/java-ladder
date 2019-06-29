package com.ladder.model;

import com.ladder.exception.UserNameLengthException;
import com.ladder.utils.AssertUtils;

import java.util.Objects;

public class UserName {

    public static final int LENGTH_OF_USER_NAME = 5;
    private final String name;

    private UserName(String name) {
        this.name = name;
    }

    static UserName of(final String name) {
        AssertUtils.checkNull(name);
        if (name.length() > LENGTH_OF_USER_NAME) {
            throw new UserNameLengthException(name);
        }
        return new UserName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "UserName{" +
                "name='" + name + '\'' +
                '}';
    }
}
