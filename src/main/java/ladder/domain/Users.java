package ladder.domain;

import java.util.List;

public class Users {
    private List<User> userList;

    public Users(List<User> userList) {
        this.userList = userList;
    }

    public List<User> userList(){
        return this.userList;
    }


}
