package ladder.domain;

public class UserIdxPair extends Pair<Integer, User> {

    private UserIdxPair(int left, User right) {
        super(left, right);
    }

    public static UserIdxPair of(int left, User right) {
        return new UserIdxPair(left, right);
    }

}
