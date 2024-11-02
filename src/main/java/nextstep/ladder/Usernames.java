package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usernames {
    List<Username> usernames = new ArrayList<>();

    public Usernames(List<String> usernameStrs){
        this.usernames = usernameStrs.stream()
                .map((str) -> new Username(str))
                .collect(Collectors.toList());
    }
}
