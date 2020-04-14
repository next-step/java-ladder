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

    public void generateResultsForAllPlayers(LadderGame ladderGame) {
        List<LadderLine> ladder = ladderGame.getLadder().getLadder();
        List<Result> results = ladderGame.getGameInfo().getResults().getResults();

        int index = 0;
        for (User user : users) {
            user.setResult(results.get(getIndex(ladder, index)).getResult());
            ++index;
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
