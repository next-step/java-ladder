package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Usernames {
    List<Username> usernames = new ArrayList<>();

    public Usernames(List<String> usernameStrs){
        for(String usernameStr : usernameStrs){
            this.usernames.add(new Username(usernameStr));
        }
    }
}
