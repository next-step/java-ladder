package ladder.domain;

import java.util.Collections;
import java.util.List;


public class ClimbResults {

    private List<ClimbResult> climbResults;

    public ClimbResults(List<ClimbResult> climbResults){
        this.climbResults = climbResults;
    }

    public List<ClimbResult> getClimbResults() {
        return Collections.unmodifiableList(climbResults);
    }
}
