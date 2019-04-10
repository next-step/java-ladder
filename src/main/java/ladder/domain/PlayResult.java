package ladder.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class PlayResult {
    private String name;
    private int resultIndex;

    public PlayResult(String name, int resultIndex) {
        this.name = name;
        this.resultIndex = resultIndex;
    }

    public boolean isEqualsName(String userName) {
        return name.equals(userName);
    }
}
