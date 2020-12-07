package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Awards {

    private List<Award> awards;

    public Awards(String[] awards){
        this.awards = Arrays.stream(awards)
                .map(Award::new)
                .collect(Collectors.toList());
    }

    public List<Award> getAwards() {
        return Collections.unmodifiableList(awards);
    }
}
