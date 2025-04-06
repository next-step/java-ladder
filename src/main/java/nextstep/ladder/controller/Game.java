package nextstep.ladder.controller;

import java.util.List;

import nextstep.ladder.module.Height;

public class Game {
    
    private final List<String> peopleNames;
    private final Height height;

    public Game(List<String> peopleNames, Height height) {
        this.peopleNames = peopleNames;
        this.height = height;
    }
    
    public Board createBoard() {
        return new Board(peopleNames.size(), height);
    }    

}
