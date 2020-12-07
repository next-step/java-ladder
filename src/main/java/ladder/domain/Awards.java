package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.domain.LadderGameConfig.FIRST_INDEX;

public class Awards {

    private final List<Award> awards;

    public Awards(String[] awards){
        this.awards = Arrays.stream(awards)
                .map(Award::new)
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
            throw new IllegalArgumentException(LadderGameErrorMessage.ILLEGAL_AWARD_INDEX.getErrorMessage());
        }

    }

}
