package ladder.service;


import ladder.domain.Ladder;
import ladder.domain.Result;
import ladder.domain.User;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderResultService
{
    private static LadderResultService ladderResultService;

    public static LadderResultService getInstance()
    {
        if (ladderResultService == null)
        {
            ladderResultService = new LadderResultService();
        }

        return ladderResultService;
    }

    public List<String> getLadderResult(String targetPlayer, List<User> userList
        , Ladder ladder, List<Result> results) {
        if (targetPlayer.equals("all")) {
            return allLadderResult(userList, ladder, results);
        }
        return userLadderResult(findUserIndex(targetPlayer, userList), ladder, results);
    }

    private List<String> userLadderResult(int userIndex, Ladder ladder, List<Result> results) {
        return List.of(results.get(ladder.move(userIndex)).getResult());
    }

    private List<String> allLadderResult(List<User> userList, Ladder ladder, List<Result> results) {
        return IntStream.range(0, userList.size())
            .mapToObj(index -> userList.get(index) + " : " + results.get(ladder.move(index)))
            .collect(Collectors.toList());
    }

    private int findUserIndex(String targetPlayer, List<User> userList) {
        return IntStream.range(0, userList.size())
            .filter(i -> Objects.equals(userList.get(i).getName(), targetPlayer))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("사다리게임에 참여하지 않은 사람입니다."));
    }
}
