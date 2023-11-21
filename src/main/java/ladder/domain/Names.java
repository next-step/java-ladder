package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Names {

    private List<Name> names;

    public Names(List<Name> names) {
        inputValidation(names);
        this.names = names;
    }

    public List<Name> names(){
        return names;
    }

    private void inputValidation(List<Name> names) {
        if(names.size() < 2){
            throw new IllegalArgumentException("이름은 최소 2개 이상이어야 합니다.");
        }
    }

}
