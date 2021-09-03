package nextstep.ladder.domain;

import java.util.List;

public class UserNames {
    private List<UserName> userNames;

    public UserNames(List<UserName> userNames) {
        this.userNames = userNames;
    }

    public int userCount() {
        return userNames.size();
    }

    public List<UserName> getValue() {
        return this.userNames;
    }
}
