package step03.domain.controller;

import step03.domain.domain.Participants;
import step03.domain.domain.StepGenerator;
import step03.domain.domain.Steps;
import step03.domain.view.ResultView;
import step03.domain.view.InputView;
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
