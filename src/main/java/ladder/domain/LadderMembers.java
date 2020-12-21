package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderMembers {
    private List<LadderMember> members;

    public LadderMembers(List<String> members) {
        if (members == null || members.size() < 2) throw new IllegalArgumentException("사다리 참가자는 최소 2명 이상 입력해야 합니다");
        int pos = 0;
        this.members = new ArrayList<>();
        for( String name: members){
            this.members.add(new LadderMember(pos++, name));
        }
    }

    public int getPosition(LadderMember member){
        return members.indexOf(member);
    }

    @Override
    public String toString() {
        return members.stream()
                .map(name -> String.format("%1$7s", name))
                .collect(Collectors.joining());
    }

    public int size() {
        return members.size();
    }

    public Stream<LadderMember> stream(){
        return members.stream();
    }

    public LadderMember findFirst(Predicate<LadderMember> condition){
        return members.stream()
                .filter(condition)
                .findFirst()
                .orElseThrow( () -> new RuntimeException("조건에 맞는 사다리 참가자는 없습니다."));
    }


}
