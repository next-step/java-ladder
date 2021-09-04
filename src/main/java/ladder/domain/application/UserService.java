package ladder.domain.application;

import ladder.domain.user.Users;

public class UserService {

    public Users createUsers(String usernames) {
        return Users.of(usernames);
    }

    public Users shuffleUsers(Users users) {
        users.shuffleUsers();
        return users;
    }

}
