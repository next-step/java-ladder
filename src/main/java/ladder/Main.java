package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.service.LadderGenerator;
import ladder.service.InputService;
import ladder.view.Input;
import ladder.view.Output;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();

        Participants participants = new Participants(InputService.parseParticipants(input.inputParticipants()));
        Ladder ladder = LadderGenerator.generateLadder(
                InputService.validateLadderHeight(input.inputLadderHeight()),
                participants.getParticipantsCount() - 1
        );

        Output.showResult(participants, ladder);
    }
}
