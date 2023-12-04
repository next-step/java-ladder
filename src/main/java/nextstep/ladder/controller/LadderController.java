package nextstep.ladder.controller;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.lines.Lines;
import nextstep.ladder.domain.lines.RandomLinesFactory;
import nextstep.ladder.service.LadderService;

public class LadderController {

    private final RandomLinesFactory randomLinesFactory;
    private final LadderService ladderService;

    public LadderController(RandomLinesFactory randomLinesFactory, LadderService ladderService) {
        this.randomLinesFactory = randomLinesFactory;
        this.ladderService = ladderService;
    }

    public Ladder startLadderGame(List<String> names, int height) {
        Lines randomLines = randomLinesFactory.createLines(height, names.size());
        return new Ladder(names, randomLines);
    }

    public List<Participant> startGame(Ladder ladder, List<String> participantsNames) {
        List<Participant> participants = participantsNames.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
        return ladderService.startLadderGame(ladder, participants);
    }
}
