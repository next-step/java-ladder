package com.seok2.ladder;

import com.seok2.ladder.game.domain.Result;
import com.seok2.ladder.game.domain.ResultAssembler;
import com.seok2.ladder.game.dto.ResultDTO;
import com.seok2.ladder.product.domain.Prizes;
import com.seok2.ladder.product.domain.PrizesAssembler;
import com.seok2.ladder.product.domain.Rewards;
import com.seok2.ladder.product.dto.PrizesDTO;
import com.seok2.ladder.structure.domain.Height;
import com.seok2.ladder.structure.domain.Ladder;
import com.seok2.ladder.structure.domain.LadderAssembler;
import com.seok2.ladder.structure.dto.LadderDTO;
import com.seok2.ladder.user.domain.Participants;
import com.seok2.ladder.user.domain.ParticipantsAssembler;
import com.seok2.ladder.user.domain.Players;
import com.seok2.ladder.user.dto.ParticipantsDTO;
import com.seok2.ladder.view.InputView;
import com.seok2.ladder.view.OutputView;

public class GameMain {

    public static void main(String[] args) {
        Participants participants = Participants.of(InputView.getNames());
        Prizes prizes = Prizes.of(InputView.getPrizes());
        Height height = Height.of(InputView.getHeight());

        Ladder ladder = Ladder.of(height, participants.size());

        LadderDTO ladderDTO = LadderAssembler.assemble(ladder);
        ParticipantsDTO participantsDTO = ParticipantsAssembler.assemble(participants);
        PrizesDTO prizesDTO = PrizesAssembler.assemble(prizes);
        OutputView.printParticipant(participantsDTO);
        OutputView.printLadder(ladderDTO);
        OutputView.printPrizes(prizesDTO);


        Players players = ladder.grab(participants);
        Rewards rewards = ladder.putDown(prizes);
        Result result = players.match(rewards);
        ResultDTO resultDTO = ResultAssembler.assemble(result);
        OutputView.printResult(resultDTO);
    }

}
