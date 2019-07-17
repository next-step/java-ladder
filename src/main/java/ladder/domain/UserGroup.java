package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class UserGroup {
    private List<SingleUser> userGroup;

    public UserGroup(String name) {
        String[] namesOfUser = LadderUtil.splitName(name);
        userGroup = new ArrayList<>();

        for (int i = 0; i < namesOfUser.length; ++i) {
            userGroup.add(SingleUser.init(namesOfUser[i], i));
        }
    }

    public List<SingleUser> getUserGroup() {
        return userGroup;
    }
}
