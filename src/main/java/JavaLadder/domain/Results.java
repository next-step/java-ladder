package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private static final String ALL_RESULT = "all";
    private List<User> resultList = new ArrayList<>();

    public Results(GameInformation gameInformation, String resultBuyPerson) {
        Users users = gameInformation.getUsers();

        if (ALL_RESULT.equals(resultBuyPerson)) {
            allUserList(users);
            return;
        }
        User user = users.getUserByName(resultBuyPerson);
        if (user == null){
            throw new IllegalArgumentException("사용자에 없는 이름입니다.[" + resultBuyPerson + "]");
        }
        resultList.add(user);
    }

    private void allUserList(Users users) {
        for (int i = 0; i < users.size(); i++) {
            resultList.add(users.getUser(i));
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