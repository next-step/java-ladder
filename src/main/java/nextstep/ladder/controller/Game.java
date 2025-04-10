package nextstep.ladder.controller;

import java.util.ArrayList;
import java.util.List;

import nextstep.ladder.module.Board;
import nextstep.ladder.module.Height;
import nextstep.ladder.module.Line;
import nextstep.ladder.module.NameList;
import nextstep.ladder.module.PointList;

public class Game {

    private final List<String> peopleNames;
    private final Height height;

    public Game(List<String> peopleNames, Height height) {
        this.peopleNames = peopleNames;
        this.height = height;
    }

    public Board createBoard() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(new Line(new PointList(peopleNames.size())));
        }
        lines.forEach(Line::createLadders);
        return new Board(lines, new NameList(peopleNames));
    }
}
