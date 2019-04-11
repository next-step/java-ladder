package domain.user;

import util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Users {
    public static final Integer MARGIN = 5;
    private static final int NO_MATCH = -1;

    private List<User> users;

    public Users(String name) {
        String[] names = StringUtils.toStringArrays(name);
        this.users = register(names);
    }

    private List<User> register(String[] names) {
        List<User> users = new ArrayList<>();
        for (String name : names) {
            users.add(new User(name));
        }
        return users;
    }

    public int size() {
        return users.size();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int findPositionByName(String name) {
        int matchIndex = NO_MATCH;

        for (int i = 0; i < users.size(); i++) {
            matchIndex = isMatch(i, matchIndex, name);
        }
        return matchIndex;
    }

    private int isMatch(int current, int matchIndex, String name) {
        if (matchIndex != NO_MATCH) return matchIndex;
        if (users.get(current).match(name)) return current;
        return NO_MATCH;
    }

    public String getUserName(int index) {
        return users.get(index).getName();
    }
}
