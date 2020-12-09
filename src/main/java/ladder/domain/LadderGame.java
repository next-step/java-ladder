package ladder.domain;


import ladder.dto.LadderWinningDTO;

import java.util.List;

public class LadderGame {

    private Persons persons;
    private Ladder ladder;
    private LadderWinnings ladderWinning;

    public LadderGame(final String names, final int ladderHeight, final String winnings) {
        initLadderGame(names, ladderHeight, winnings);
    }

    private void initLadderGame(final String names, final int ladderHeight, final String winnings) {
        this.persons = new Persons(names);
        this.ladder = new Ladder(ladderHeight, persons.getPersons().size());
        this.persons = new Persons(persons, ladder.getLadderLine().get(ladder.getLadderLine().size() - 1).getPositionList());
        this.ladderWinning = new LadderWinnings(winnings, this.persons);
    }

    public List<LadderWinningDTO> getWinningResult(String name){

        if(name.equals("all")){
            return ladderWinning.getAllWinningResult();
        }

        return ladderWinning.getOneWinningResult(name);
    }

    public List<LadderWinning> getWinnings(){
        return ladderWinning.getWinnings();
    }

    public Persons getPerson() {
        return persons;
    }

    public Ladder getLadder() {
        return ladder;
    }

}
