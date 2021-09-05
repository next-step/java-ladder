package nextstep.ladder;

import nextstep.ladder.participant.Participant;
import nextstep.ladder.participant.Participants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Ladder {

    private Participants participants;
    private List<Line> lines;
    private MiddleLadder randomPoint;
    private List<Result> results;

    private Ladder(Participants participants, MiddleLadder randomPoint, int depth) {
        this.participants = participants;
        this.randomPoint = randomPoint;
        lines = new ArrayList<>();
        for (int high = 0; high < depth; high++) {
            lines.add(Line.of(participants.size() - 1, randomPoint));
        }
    }

    public static Ladder of(Participants participants, MiddleLadder randomPoint, int depth) {
        return new Ladder(participants, randomPoint, depth);
    }

    public static Ladder of(LadderInput input) {
        return new Ladder(input.getParticipants(), input.getRandomPoint(), input.getDepth());
    }

    public int getDepth() {
        return lines.size();
    }

    public int getParticipantsCount() {
        return participants.size();
    }

    public List<String> getNames() {
        return participants.getNames();
    }

    public int getLineSize() {
        return lines.get(0).getSize();
    }

    public List<Line> getLines() {
        return new ArrayList<Line>(lines);
    }

    public void putResult(String... result) {
        AtomicInteger position = new AtomicInteger();
        results = Arrays.stream(result)
                .map(name -> Result.of(name, new Position(position.getAndIncrement(), this.participants.size())))
                .collect(Collectors.toList());
    }

    public void playLadderGame(){
        for(Participant participant : participants.getList()){
            Position position = participant.getPosition();
            for(Line line : lines){
                if(position.getInteger() != participants.size()-1 && line.getList().get(position.getInteger())){
                    participant.movePosition(position.getInteger());
                }else if(position.getInteger()!=0 && line.getList().get(position.getInteger()-1)){
                    participant.movePosition(position.getInteger()-1);
                }
                position = participant.getPosition();
            }
        }
    }

    public Participants getParticipants() {
        return participants;
    }
}
