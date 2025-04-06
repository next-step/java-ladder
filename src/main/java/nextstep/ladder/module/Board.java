package nextstep.ladder.module;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final NameList nameList;
    private final Height height;
    private List<Line> lines;
    
    
    public Board(NameList nameList, Height height) {
        this.nameList = nameList;
        this.height = height;
    }

    public void createLines() {
        lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(new Line(nameList.size()));
        }
    }

    public void createLadders() {
        lines.forEach(Line::createLadders);
    }

}
