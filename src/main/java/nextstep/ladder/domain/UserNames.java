package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserNames {
    private final List<UserName> userNames;

    private UserNames() {
        userNames = new ArrayList<>();
    }

    private UserNames(List<UserName> userNames) {
        this.userNames = userNames;
    }

    public static UserNames of(String[] names) {
        List<UserName> userNames = Arrays.stream(names)
                .map(name -> UserName.of(name))
                .collect(Collectors.toList());
        return new UserNames(userNames);
    }

    public List<UserName> userNames() {
        return Collections.unmodifiableList(userNames);
    }

    public int count() {
        return userNames.size();
    }

}
