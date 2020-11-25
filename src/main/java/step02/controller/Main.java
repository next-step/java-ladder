package step02.controller;

import step02.domain.Participants;
import step02.domain.StepGenerator;
import step02.domain.Steps;
import step02.view.InputView;
import step02.view.ResultView;
import strategy.RandomPointStrategy;

public class Main {
    public static void main(String[] args) {

        String namesOfParticipants = InputView.readNamesOfParticipants();
        Participants participants = Participants.of(namesOfParticipants);

        Integer heightOfLadder = InputView.readCountOfSteps();
        StepGenerator stepGenerator = StepGenerator.of(participants, RandomPointStrategy.of());
        Steps steps = Steps.of(heightOfLadder, stepGenerator);
        ResultView.print(participants, steps);

    }
}
