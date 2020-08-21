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
    private List<Line> ladder;
    private int state;

    Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder create(LadderBaseInputData ladderBaseInputData){
        return LadderBuilder.create(ladderBaseInputData);
    }

    Ladder participant(String participant){
        state = ladder.get(0).indexOf(participant);
        return this;
    }

    Ladder movable(){
        state = ladder.get(1).indexOf(state);
        return this;
    }

    String result(){
        return ladder.get(2).getResult(state);
    }

    String ride(String participant){
        return participant(participant)
            .movable()
            .result();
    }

    public Ladder ridingLoop(Supplier<String> participantSupplier, Consumer<String> displayRidingResult){
        String participant;
        while(!hasKeyword(participant = participantSupplier.get())){
            displayRidingResult.accept(ride(participant));
        }
        return this;
    }

    public void orAllLadderRidingResult(Consumer<String> displayRidingResult){
        String result = ladder.get(0)
                               .getNames()
                               .getPrimitiveNames()
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
        return ladder.stream()
            .map(l -> l.toDisplayResult().toDisplay())
            .collect(joining("\n"));
    }
}
