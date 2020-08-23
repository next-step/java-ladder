package ladder.domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import ladder.domain.core.line.Line;
import ladder.ui.LadderBaseInputData;
import ladder.ui.result.DisplayResult;

import static java.util.stream.Collectors.joining;

public class Ladder implements DisplayResult {
    private static final String COMMAND_KEYWORD = "all";
    private final LadderStatefulOperation ladderStatefulOperation;

    Ladder(List<Line> ladder) {
        ladderStatefulOperation = new LadderStatefulOperation(ladder);
    }

    public static Ladder create(LadderBaseInputData ladderBaseInputData){
        return LineTransformationForLadder.create(ladderBaseInputData);
    }

    String ride(String participant){
         return ladderStatefulOperation.prepar(participant)
                                       .result(Line::getResult);
    }

    public Ladder ridingLoop(Supplier<String> participantSupplier, Consumer<String> displayRidingResult){
        String participant;
        while(!hasKeyword(participant = participantSupplier.get())){
            displayRidingResult.accept(ride(participant));
        }
        return this;
    }

    public void orAllLadderRidingResult(Consumer<String> displayRidingResult){
        String result = ladderStatefulOperation.participants()
                               .stream()
                               .map(p -> String.format("%s : %s", p, ride(p)))
                               .collect(joining("\n"));
        displayRidingResult.accept(result);
    }

    public static boolean hasKeyword(String keyword){
        return COMMAND_KEYWORD.equals(keyword);
    }

    @Override
    public String toDisplay() {
        return ladderStatefulOperation
            .lines()
            .stream()
            .map(l -> l.toDisplayResult().toDisplay())
            .collect(joining("\n"));
    }
}
