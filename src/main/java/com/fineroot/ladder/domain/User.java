package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.ExceptionMessage;
import java.util.Objects;

public class User {

    private String name;

    private User(String name){
        validation(name);
        this.name = name;
    }

    public static User from(String name){
        return new User(name);
    }

    private void validation(String name) {
        if(name.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessage.USER_NAME_EMPTY.getMessage());
        }
        if (name.length()>5){
            throw new IllegalArgumentException(ExceptionMessage.USER_NAME_LENGTH_OVER.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
