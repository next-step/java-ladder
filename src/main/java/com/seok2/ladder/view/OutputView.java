package com.seok2.ladder.view;

import com.seok2.ladder.structure.dto.LadderDTO;
import com.seok2.ladder.user.dto.ParticipantDTO;
import com.seok2.ladder.user.dto.ParticipantsDTO;
import java.util.List;

public class OutputView {

    private static final String BLANK = "  ";
    private static final String VERTICAL_LINE = "|      ";
    private static final String HORIZONTAL_LINE = "|------";

    public static void printParticipant(ParticipantsDTO participantsDTO) {
        List<ParticipantDTO> participants = participantsDTO.getParticipants();
        for (ParticipantDTO participant : participants) {
            System.out.print(participant.getName() + BLANK);
        }
    }

    public static void printLadder(LadderDTO ladderDTO) {
//        ladderDTO.getLayers().stream()
//            .flatMap(x -> {
//                System.out.println();
//                return x.getLayer().stream();
//            })
//            .forEach(y -> System.out.print( ? HORIZONTAL_LINE : VERTICAL_LINE));
    }

}
