package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserNames {

    private static final int MIN_COUNT_OF_PERSON = 2;
    private final List<UserName> userNames;

    private UserNames() {
        userNames = new ArrayList<>();
    }

    private UserNames(List<UserName> userNames) {
        this.userNames = userNames;
    }

    public static UserNames of(List<UserName> userNames) {
        return new UserNames(userNames);
    }

    public static UserNames of(String[] names) {
        if(names.length < MIN_COUNT_OF_PERSON) {
            throw new IllegalArgumentException("사다리 게임 진행을 위한 최소 인원 수는 2명입니다.");
        }
        List<UserName> userNames = Arrays.stream(names)
                .map(name -> UserName.of(name.trim()))
                .collect(Collectors.toList());
        return new UserNames(userNames);
    }

    public List<UserName> userNames() {
        return Collections.unmodifiableList(userNames);
    }

    public String userName(int index) {
        return userNames.get(index).name();
    }

    public int count() {
        return userNames.size();
    }

}
