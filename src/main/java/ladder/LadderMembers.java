package ladder;

import java.util.List;
import java.util.stream.Collectors;

public class LadderMembers {
    private List<String> names;

    public LadderMembers(List<String> names) {
        if( names == null || names.size() < 2 ) throw new IllegalArgumentException("사다리 참가자는 최소 2명 이상 입력해야 합니다");
        names.forEach( name -> {
            if(name.length() > 5) throw new IllegalArgumentException("사다리 참가자명은 최대5자 까지 입력가능합니다. (name: " + name + ")");
        });
        this.names = names;
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
}
