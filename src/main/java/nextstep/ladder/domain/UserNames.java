package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserNames {
    private List<UserName> userNames;

    private UserNames() {
        userNames = new ArrayList<>();
    }

    public static UserNames of(List<String> names) {
        UserNames userNames = new UserNames();
        userNames.userNames = names.stream()
                .map(name -> UserName.of(name))
                .collect(Collectors.toList());

        return userNames;
    }

    public List<UserName> userNames(){
        return userNames;
    }

}
