package domain.user;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static final String DELIMITER = ",";
    private List<User> users;

    public Users(String name) {
        String[] names = name.split(DELIMITER);
        this.users = register(names);
    }

    private List<User> register(String[] names) {
        List<User> users = new ArrayList<>();
        for(String name : names) {
            users.add(new User(name));
        }
        return users;
    }

    public int size() {
        return users.size();
    }

    //TODO : 결과출력 위한 maxMargin 구하는 method 추가 필요

}
