package step03.controller;

import step03.domain.Participant;
import step03.domain.Participants;
import step03.domain.Steps;
import step03.domain.StepGenerator;
import step03.view.InputView;
import step03.view.ResultView;
import strategy.RandomPointStrategy;

public class Main {
    public static void main(String[] args) {

        Participants participants = readParticipants();


        Integer heightOfLadder = InputView.readCountOfSteps();
        StepGenerator stepGenerator = StepGenerator.of(participants, RandomPointStrategy.of());
        Steps steps = Steps.of(heightOfLadder, stepGenerator);
        ResultView.print(participants, steps);

    }

    public static Participants readParticipants() {
        String namesOfParticipants = InputView.readNamesOfParticipants();
        return Participants.of(namesOfParticipants);
    }
}
