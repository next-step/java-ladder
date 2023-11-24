package ladder_v2.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Name> names = new ArrayList<>();

    public Players(List<Name> names) {
        if(names.size() < 2){
            throw new IllegalArgumentException("Player는 최소 2명 이상이어야 합니다.");
        }
        this.names = names;
    }

    public List<Name> names(){
        return names;
    }

    public Name get(int i) {
        return names.get(i);
    }
}
