package nextstep.ladder.domain;

import java.util.List;

public class UserNames {
    private List<String> names;

    public UserNames(List<String> names) {
        checkNameLength(names);
        this.names = names;
    }

    private void checkNameLength(List<String> stringNames) {
        if(stringNames.stream().anyMatch(name -> name.length() > 5))
            throw new IllegalArgumentException("사람 이름은 5글자 이하여야합니다.");
    }

    public int getUserCount() {
        return names.size();
    }

    public List<String> getNames() {
        return names;
    }

}
