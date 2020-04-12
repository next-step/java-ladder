package nextstep.ladder.domain;

import java.util.List;

public class PlayLadderGame2 {
    private static PlayLadderGame2 playLadderGame = new PlayLadderGame2();

    public Users generateResultsForAllPlayers(GameInfo paramGameInfo, Ladder2 paramLadder) {
        Users users = paramGameInfo.getUsers();
        List<User> userList = users.getUsers();
        List<LadderLine> ladder = paramLadder.getLadder();
        List<Result> results = paramGameInfo.getResults().getResults();

        for (int i = 0; i < users.getCountOfPerson(); i++) {
            int index = i;
            index = getIndex(ladder, index);
            userList.get(i).setResult(results.get(index).getResult());
        }
        return new Users(userList);
    }

    private int getIndex(List<LadderLine> ladder, int index) {
        for (int j = 0; j < ladder.size(); j++) {
            index = ladder.get(j).move(index);
        }
        return index;
    }

    public static PlayLadderGame2 getPlayLadderGame() {
        return playLadderGame;
    }
}
