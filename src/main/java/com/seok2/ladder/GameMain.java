package com.seok2.ladder;

import com.seok2.ladder.structure.domain.Height;
import com.seok2.ladder.structure.domain.Ladder;
import com.seok2.ladder.structure.domain.LadderAssembler;
import com.seok2.ladder.structure.dto.LadderDTO;
import com.seok2.ladder.user.domain.Participants;
import com.seok2.ladder.user.domain.ParticipantsAssembler;
import com.seok2.ladder.user.dto.ParticipantsDTO;
import com.seok2.ladder.view.InputView;
import com.seok2.ladder.view.OutputView;

public class GameMain {

    public static void main(String[] args) {
        Participants participants = Participants.of(InputView.getNames());
        Height height = Height.of(InputView.getHeigth());

        Ladder ladder = Ladder.of(height, participants.size());

        LadderDTO ladderDTO = LadderAssembler.assemble(ladder);
        ParticipantsDTO participantsDTO = ParticipantsAssembler.assemble(participants);

        OutputView.printParticipant(participantsDTO);
        OutputView.printLadder(ladderDTO);
    }

}
