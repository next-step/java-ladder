package nextstep.ladder.domain.result;


import static nextstep.ladder.utils.Constants.NOT_EXIST_USER_CODE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.error.exception.LadderUsersMismatchException;
import nextstep.ladder.error.exception.NotExistUserException;

public class LadderResult {
    private final Map<User, Integer> ladderResult = new HashMap<>();
    private List<String> drewList;

    public LadderResult(List<String> drewList, Users users) {
        if (drewList.size() != users.size()){
            throw new LadderUsersMismatchException(drewList.size(), users.size());
        }

        this.drewList = drewList;
    }

    public void calculateLadderResult(Users users, Lines lines) {
        users.addLadderResult(ladderResult, lines);
    }

    public String userDrawResult(User user) throws NotExistUserException {
        int result = ladderResult.getOrDefault(user, NOT_EXIST_USER_CODE);

        if (NOT_EXIST_USER_CODE == result){
            throw new NotExistUserException(user.getUserName());
        }

        return drewList.get(result);
    }

    public Set<User> keySet(){
        return ladderResult.keySet();
    }
}
