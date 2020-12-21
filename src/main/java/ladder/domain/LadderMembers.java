package ladder.domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LadderMembers {
    private List<LadderMember> names;

    public LadderMembers(List<String> names) {
        if (names == null || names.size() < 2) throw new IllegalArgumentException("사다리 참가자는 최소 2명 이상 입력해야 합니다");
        this.names = names.stream().map(LadderMember::new).collect(Collectors.toList());
    }

    public int getPosition(LadderMember member){
        return names.indexOf(member);
    }

    @Override
    public String toString() {
        return names.stream()
                .map(name -> String.format("%1$7s", name))
                .collect(Collectors.joining());
    }

    public int size() {
        return names.size();
    }

    public void forEach(Consumer<? super LadderMember> action) {
        names.forEach(action);
    }

}
