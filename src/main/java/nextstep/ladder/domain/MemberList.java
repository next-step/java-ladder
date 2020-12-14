package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemberList {
    
    private List<Member> members;

    public List<Member> getMembers(){
        return members;
    }

    public void setMembers(String memberNames){
        String[] array = memberNames.split(",");
        List<Member> list = new ArrayList<>();
        Arrays.stream(array)
                .forEach(s -> {
                    Member member = new Member(s);
                    list.add(member);
                });

        this.members = list;
    }
}