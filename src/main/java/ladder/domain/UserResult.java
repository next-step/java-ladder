package ladder.domain;

import static java.lang.Integer.compare;

public class UserResult implements Comparable<UserResult> {
    private final int startIndex;
    private final String name;
    private final String result;

    public UserResult(int startIndex, String name, String result) {
        this.startIndex = startIndex;
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    @Override
    public int compareTo(UserResult other) {
        return compare(this.startIndex, other.startIndex);
    }
}
