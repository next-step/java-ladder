package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    public UserNames creatUser(String names) {
        List<String> userNames = Arrays.stream(names.split(","))
                .collect(Collectors.toList());
        return UserNames.of(userNames);
    }

}
