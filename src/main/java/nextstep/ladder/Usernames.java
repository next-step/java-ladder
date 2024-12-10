package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usernames {
    private List<Username> usernames = new ArrayList<>();

    public Usernames(List<String> usernameStrs) {
        //todo 이름 중복
        if (usernameStrs.size() == 0) {
            throw new IllegalArgumentException("참여자가 없습니다.");
        }
        this.usernames = usernameStrs.stream()
                .map((str) -> new Username(str))
                .collect(Collectors.toList());
    }

    public List<Username> getValues() {
        return usernames;
    }


    //todo 이렇게 작성해도 되는지??
    public String getUsername(int index) {
        return usernames.get(index).getUsername();
    }

    public int size() {
        return usernames.size();
    }

    public int indexOf(String username) {
        return usernames.indexOf(new Username(username));
    }

    public String toString() {
        return String.join(
                "",
                this.usernames
                        .stream()
                        .map(str -> str.getUsernameForPrint())
                        .collect(Collectors.toList())
        );
    }

    public String getUsernamesForPrint() {
        return usernames.stream()
                .map(d -> String.format("%-6s", d.getUsername()))
                .collect(Collectors.joining());
    }
}
