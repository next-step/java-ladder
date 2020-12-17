package nextstep.step2.VO;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<User> userList = new ArrayList<>();

    public Users(List<User> userList) {
        this.userList = userList;
    }

    public int getUserListSize() {
        return userList.size();
    }
}
