package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.doamin.People;
import nextstep.ladder.controller.dto.LadderCreateParam;
import nextstep.ladder.doamin.Ladder;
import nextstep.ladder.doamin.value.Location;
import nextstep.ladder.doamin.fcatory.LineFactory;
import nextstep.ladder.strategy.RandomLineStrategy;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LadderController ladderController = new LadderController(new RandomLineStrategy(), new LineFactory());

        People people = inputView.inputPersonName();
        List<String> result = inputView.inputExecutionResult(people);
        Integer heightOfLadder = inputView.inputHeightOfLadder();

        Ladder ladder = ladderController.createLadder(LadderCreateParam.of(people, heightOfLadder));
        resultView.printLadder(people, ladder, result);

        while (true) {
            String personName = inputView.inputResultOfPerson();

            if (personName.equals("all")) {
                people.getPoints().forEach(name -> {
                    Integer position = people.getLocation(name.getName());
                    Location location = ladder.getLadderResult(Location.from(position));
                    System.out.println(name.getName() + ":" + result.get(location.getCurrentLocation()));
                });

            } else {
                Integer position = people.getLocation(personName);
                Location location = ladder.getLadderResult(Location.from(position));
                System.out.println(result.get(location.getCurrentLocation()));
            }
        }
    }
}
