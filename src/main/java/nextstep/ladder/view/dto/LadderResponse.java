package nextstep.ladder.view.dto;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Participant;
import nextstep.ladder.model.Point;
import nextstep.ladder.model.Result;

import java.util.List;
import java.util.stream.Collectors;

public final class LadderResponse {

    private final List<String> participant;
    private final List<List<Boolean>> lines;
    private final List<String> results;

    private LadderResponse(List<String> participant, List<List<Boolean>> lines, List<String> results) {
        this.participant = participant;
        this.lines = lines;
        this.results = results;
    }


    public static LadderResponse from(Ladder ladder) {
        return new LadderResponse(
                participants(ladder),
                lines(ladder),
                results(ladder)
        );
    }

    private static List<List<Boolean>> lines(Ladder ladder) {
        return ladder.lines()
                .list()
                .stream()
                .map(LadderResponse::connections)
                .collect(Collectors.toList());
    }

    private static List<Boolean> connections(Line line) {
        return line.points()
                .stream()
                .map(Point::isConnected)
                .collect(Collectors.toList());
    }

    private static List<String> results(Ladder ladder) {
        return ladder.environment()
                .results()
                .list()
                .stream()
                .map(Result::value)
                .collect(Collectors.toList());
    }

    private static List<String> participants(Ladder ladder) {
        return ladder.environment()
                .participants()
                .list()
                .stream()
                .map(Participant::value)
                .collect(Collectors.toList());
    }

    public List<String> getParticipants() {
        return participant;
    }

    public List<List<Boolean>> getLines() {
        return lines;
    }

    public List<String> getResults() {
        return results;
    }
}
