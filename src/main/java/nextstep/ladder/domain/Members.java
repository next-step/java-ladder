package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;

public class Members {

    private List<Member> members;
    public Members(String members){
        this(valueOf(members));
    }

    public Members(List<Member> members){
        this.members = members;
    }

    private static List<Member> valueOf(String members){
        return Arrays.stream(members.split(","))
                .map(Member::new)
                .collect(Collectors.toList());
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public int getSize() {
        return members.size();
    }
}
