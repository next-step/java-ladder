package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int HEIGHT_MINIMUM_NUMER = 1;

    private List<LadderLine> lines = new ArrayList<>();

    public Ladder(int height, int countOfPerson) {
        validate(height);
        for (int i = 0; i < height; i++) {
            this.lines.add(LadderLine.init(countOfPerson));
        }
    }

    private void validate(int height) {
        if (height < HEIGHT_MINIMUM_NUMER) {
            throw new IllegalArgumentException("높이값 오류");
        }
    }

    public int getLineHeight() {
        return this.lines.size();
    }

    public LadderLine getDrawLine(int linePosition) {
        return lines.get(linePosition);
    }

//    public void playLadderGame(Players players) {
//        for (int i = 0; i < lines.size(); i++) {
//            players.move(lines.get(i));
//        }
//    }

}
