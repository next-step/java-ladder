package nextstep.ladder.model;

import java.util.Objects;

public final class UserResult {

    private final User user;
    private final LadderResult result;

    public UserResult(User user, LadderResult result) {
        validate(user, result);
        this.user = user;
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public String userName() {
        return user.getName();
    }

    public LadderResult getResult() {
        return result;
    }

    public String ladderResult() {
        return result.getValue();
    }

    private void validate(User user, LadderResult result) {
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("사용자 결과에 필요한 사용자 정보가 null입니다.");
        }
        if (Objects.isNull(result)) {
            throw new IllegalArgumentException("사용자의 사다리 타기 결과가 null입니다.");
        }
    }
}
