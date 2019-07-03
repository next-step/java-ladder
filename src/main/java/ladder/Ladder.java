package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private List<LadderLine> ladder;

    public Ladder(int height, int playersCount) {
        this.ladder = ladderGenerator(height, playersCount);
    }

    public List<LadderLine> ladderGenerator(int height, int playersCount) {
        List<LadderLine> ladderMaterial = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderMaterial.add(new LadderLine(playersCount));
        }
        return ladderMaterial;
    }

    public int size() {
        return ladder.size();
    }

    public LadderLine getLadderLine(int i) {
        return ladder.get(i);
    }

    public List<LadderLine> getLadder(){
        return Collections.unmodifiableList(ladder);
    }

}
