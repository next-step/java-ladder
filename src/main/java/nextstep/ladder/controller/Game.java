package nextstep.ladder.controller;

import java.util.List;

import nextstep.ladder.module.Board;
import nextstep.ladder.module.Height;
import nextstep.ladder.module.NameList;

public class Game {
    
    private final List<String> peopleNames;
    private final Height height;

    public Game(List<String> peopleNames, Height height) {
        this.peopleNames = peopleNames;
        this.height = height;
    }
    
    public Board createBoard() {
        return new Board(new NameList(peopleNames), height);
    }    

}
