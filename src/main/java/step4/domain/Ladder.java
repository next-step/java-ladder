package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder init(int height, int sizeOfPerson) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderLines.add(LadderLine.init(sizeOfPerson));
        }
        return new Ladder(ladderLines);
    }

    public List<Integer> move(int sizeOfPerson) {
        List<Integer> ladderResult = new ArrayList<>();
        int height = ladderLines.size();
        for (int index = 0; index < sizeOfPerson; index++) {
            int userIndex = index;
            for (LadderLine ladderLine : ladderLines) {
                userIndex = ladderLine.move(userIndex);
            }
            ladderResult.add(userIndex);
        }
        System.out.println(ladderResult);
        return ladderResult;
    }


    public List<LadderLine> ladderLines() {
        return ladderLines;
    }
}
