package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.dto.response.LadderDto;
import ladder.view.ResponseView;

public class Main {

    public static void main(String[] args) {
        Players players = ModelMapper.getPlayers();
        Ladder ladder = ModelMapper.getLadder();

        LadderDto ladderDto = new LadderDto(players);
        ResponseView.printLadder(ladderDto);
    }
}
