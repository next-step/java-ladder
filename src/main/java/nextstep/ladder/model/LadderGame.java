package nextstep.ladder.model;

import nextstep.ladder.controller.UserLadderResults;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LadderGame {

    private final Ladder ladder;
    private final UserLadderResults userLadderResults;

    public LadderGame(Ladder ladder, UserLadderResults userLadderResults) {
        validate(ladder, userLadderResults);
        this.ladder = ladder;
        this.userLadderResults = userLadderResults;
    }

    private void validate(Ladder ladder, UserLadderResults userLadderResults) {
        if (Objects.isNull(ladder)) {
            throw new IllegalArgumentException("사다리 게임에 필요한 '사다리 정보'가 null 입니다.");
        }
        if (Objects.isNull(userLadderResults)) {
            throw new IllegalArgumentException("사다리 게임의 결과에 필요한 '사용자 정보'와 '사라디 결과 정보'가 null 입니다.");
        }
    }

    public UserResults userResults() {
        return UserResults.from(processedUserResults());
    }

    private List<UserResult> processedUserResults() {
        return IntStream.range(0, userLadderResults.size())
                .boxed()
                .map(this::userResult)
                .collect(Collectors.toList());
    }

    private UserResult userResult(int userIndex) {
        return new UserResult(
                userLadderResults.getUser(userIndex),
                userLadderResults.getLadderResult(ladder.move(userIndex))
        );
    }
}
