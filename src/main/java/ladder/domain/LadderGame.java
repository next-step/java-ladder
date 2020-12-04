package ladder.domain;


import ladder.dto.LadderLineDTO;

import java.util.List;

public class LadderGame {
    private Persons person;
    private LadderLineDTO ladderLineDTO = new LadderLineDTO();

    public LadderGame(final String names, final int ladderHeight) {
        initLadderGame(names, ladderHeight);
    }

    private void initLadderGame(final String names, final int ladderHeight) {
        this.person = new Persons(names);
        LadderLine ladderLine = new LadderLine(ladderHeight, person.getNames().size());
        this.ladderLineDTO = ladderLine.getLadderLineDTO();
    }

    public LadderLineDTO getLadderLineDTO() {
        return ladderLineDTO;
    }

    public List<String> getNames(){
        return person.getNames();
    }
}
