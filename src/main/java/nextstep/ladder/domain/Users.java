package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Users {
    private List<User> users;

    public Users(List<User> users) {
        this.users = Collections.unmodifiableList(new ArrayList<>(users));
    }

    public int getCountOfPerson() {
        return users.size();
    }

    public void checkValidateResults(Results results) {
        if (getCountOfPerson() != results.getResults().size()) {
            throw new IllegalArgumentException("참여할 사람과 실행 결과의 수는 같아야 합니다");
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
