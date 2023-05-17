package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Usernames {

    private final List<Username> usernames;

    public Usernames(List<String> usernames) {
        this.usernames = toUsernames(usernames);
    }

    private List<Username> toUsernames(List<String> usernames) {
        return usernames.stream()
                .map(Username::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return usernames.size();
    }

    public int getUsernameIndex(Username username) {
        return usernames.indexOf(username);
    }

    public List<Username> getUsernames() {
        return usernames;
    }
}
