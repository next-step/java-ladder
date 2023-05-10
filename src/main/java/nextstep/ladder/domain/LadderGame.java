package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final ParticipantNames participantNames;
    private final Lines lines;

    public LadderGame(ParticipantNames participantNames, Height height, GenerateLadderPointStrategy generateLadderPointStrategy) {
        this.participantNames = participantNames;
        this.lines = setLines(participantNames.size(), height, generateLadderPointStrategy);
    }

    private static Lines setLines(int countOfParticipant, Height height, GenerateLadderPointStrategy generateLadderPointStrategy) {
        List<Line> lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Line(countOfParticipant, generateLadderPointStrategy))
                .collect(Collectors.toList());

        return new Lines(lines);
    }

    public ParticipantNames getParticipantNames() {
        return participantNames;
    }

    public Lines getLines() {
        return lines;
    }

}
