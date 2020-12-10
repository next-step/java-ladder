package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Awards {

    private static final int FIRST_INDEX = 0;
    private final List<Award> awards;

    public Awards(String[] awards){
        this.awards = Arrays.stream(awards)
                .map(Award::from)
                .collect(Collectors.toList());
    }

    public List<Award> getAwards() {
        return Collections.unmodifiableList(awards);
    }

    public Award searchAwardName(int index) {
        validateAwardIndex(index);
        return awards.get(index);
    }

    private void validateAwardIndex(int index) {
        if(index < FIRST_INDEX || index >= awards.size()){
            throw new IllegalArgumentException("해당 위치에 결과값이 존재하지 않습니다.");
        }

    }

}
