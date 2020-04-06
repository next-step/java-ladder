package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultList {
    private static final String ALL_RESULT = "all";
    private List<User> resultList = new ArrayList<>();

    public ResultList(UserList userList, String resultBuyPerson) {
        if (ALL_RESULT.equals(resultBuyPerson)) {
            allUserList(userList);
            return;
        }
        this.resultList.add(userList.getUserByName(resultBuyPerson));
    }

    private void allUserList(UserList userList) {
        for (int i = 0; i < userList.size(); i++) {
            this.resultList.add(userList.getUser(i));
        }
    }

    public int size() {
        return resultList.size();
    }

    public String getResultName(int index) {
        return resultList.get(index).getName();
    }

    public Point getResultPoint(int index) {
        return resultList.get(index).getPoint();
    }
}
