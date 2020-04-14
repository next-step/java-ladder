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

    public void generateResultsForAllPlayers(GameInfo paramGameInfo, Ladder paramLadder) {
        List<LadderLine> ladder = paramLadder.getLadder();
        List<Result> results = paramGameInfo.getResults().getResults();

        for (int i = 0; i < getCountOfPerson(); i++) {
            int index = i;
            index = getIndex(ladder, index);
            users.get(i).setResult(results.get(index).getResult());
        }
    }

    private int getIndex(List<LadderLine> ladder, int index) {
        for (int j = 0; j < ladder.size(); j++) {
            index = ladder.get(j).move(index);
        }
        return index;
    }

    public List<User> getUsers() {
        return users;
    }
}
