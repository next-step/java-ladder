package nextstep.ladder.domain;

import nextstep.ladder.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class GameResult {
    private final Map<String, String> gameResult = new HashMap<>();

    public GameResult(Ladder ladder, Users users) {
        List<String> orderLadderResult = matchByOrder(ladder);
        setGameResult(users, orderLadderResult);
    }

    private List<String> matchByOrder(Ladder ladder) {
        List<String> ladderResult = ladder.getLadderResult();
        List<Line> lines = ladder.getLines();

        List<String> orderLadderResult = new ArrayList<>();

        for (int i = 0; i < ladderResult.size(); i++) {
            orderLadderResult.add(ladderResult.get(findIndex(lines, i)));
        }

        return orderLadderResult;
    }

    private int findIndex(List<Line> lines, int startIndex) {
        int nextIndex = startIndex;

        for (Line line : lines) {
                nextIndex = getNextIndex(line, nextIndex);
        }

        return nextIndex;
    }

    private int getNextIndex(Line line, int index){

        //오른쪽으로 가야하는 경우
        if (index != line.getLength() && line.getLine().get(index)) {
            return index + 1;
        }

        //왼쪽으로 가야하는 경우
        if (index != 0 && line.getLine().get(index-1)) {
            return index-1;
        }

        return index;
    }

    private void setGameResult(Users users, List<String> result) {
        List<String> userNames = users.getUsers().stream()
                .map(User::getUserName)
                .collect(Collectors.toUnmodifiableList());

        for (int i = 0; i < result.size(); i++) {
            this.gameResult.put(userNames.get(i), result.get(i));
        }
    }

    public String getGameResultByUserName(String userName) {
        String errorMessage = "[결과] 해당 유저는 없습니다.";
        return Optional.ofNullable(gameResult.get(userName))
                .orElseThrow(() -> new NoSuchElementException(errorMessage));
    }
}
