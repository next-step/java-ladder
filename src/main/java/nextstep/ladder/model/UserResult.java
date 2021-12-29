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

    public boolean hasUserName(UserName userName) {
        return user.hasName(userName);
    }

    private void validate(User user, LadderResult result) {
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("전달된 사용자 정보가 null 입니다.");
        }
        if (Objects.isNull(result)) {
            throw new IllegalArgumentException("전달된 사용자의 사다리 타기 결과가 null 입니다.");
        }
    }
}
