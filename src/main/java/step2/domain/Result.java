package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private final Map<Integer, Integer> indexValue;
    private final Map<User, Prize> realValue = new HashMap<>();

    public Result(Map<Integer, Integer> indexValue) {
        this.indexValue = indexValue;
    }

    public Prize prize(User user) {
        return realValue.get(user);
    }

    public void reformat(Users users, Prizes prizes) {
        List<User> userList = users.value();
        List<Prize> prizeList = prizes.value();

        for (int userIndex = 0; userIndex < users.size(); ++userIndex) {
            Integer prizeIndex = indexValue.get(userIndex);
            realValue.put(userList.get(userIndex), prizeList.get(prizeIndex));
        }
    }
}
