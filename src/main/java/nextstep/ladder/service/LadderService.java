package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;

public class LadderService {
    public Ladder setupLadder(String[] list, int height){
        Ladder ladder = new Ladder();
        ladder.setLadder(list.length, height);
        return ladder;
    }
}