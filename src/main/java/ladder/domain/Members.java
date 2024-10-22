package ladder.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Members {
    private final List<Member> members;

    public Members(List<Member> members) {
        Set<Member> setMembers = new HashSet<>(members);
        if (setMembers.size() != members.size()) {
            throw new IllegalArgumentException("맴버에 중복은 허용하지 않습니다.");
        }
        this.members = members;
    }

    public int getSize() {
        return members.size();
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public Member getMember(int index) {
        if (index < 0 || index >= members.size()) {
            throw new IllegalArgumentException("객체 범위 외의 인덱스는 허용하지 않습니다.");
        }
        return members.get(index);
    }

}
