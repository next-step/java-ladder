package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.ExceptionMessage;
import java.util.Objects;

public class User implements Comparable<User>{

    private String name;

    private static final String ALL = "all";

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

    public int length(){
        return name.length();
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

    public boolean isAll(){
        return name.equals(ALL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.name.length(), o.name.length());
    }

    @Override
    public String toString() {
        return name;
    }
}
