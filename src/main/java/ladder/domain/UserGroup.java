package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class UserGroup {
    private static final String SEPARATOR = ",";

    private List<SingleUser> userGroup;

    public UserGroup(String name) {
        String[] namesOfUser = splitName(name);
        userGroup = new ArrayList<>();

        for (int i = 0; i < namesOfUser.length; ++i) {
            userGroup.add(SingleUser.init(namesOfUser[i], i));
        }
    }

    public List<SingleUser> getUserGroup() {
        return userGroup;
    }

    private String[] splitName(String names) {
        return names.split(SEPARATOR);
    }
}
