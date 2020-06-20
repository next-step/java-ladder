package ladder.model.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.LadderGameInfo;
import ladder.model.LadderLine;
import ladder.model.LadderPoleInfo;

public class LadderGameResultDto {

    private static final int ZERO = 0;
    private final List<LadderPoleInfo> ladderPoleInfos;
    private final List<LadderLine> ladderLines;

    private LadderGameResultDto(final List<LadderPoleInfo> ladderPoleInfos, final List<LadderLine> ladderLines) {
        this.ladderPoleInfos = Collections.unmodifiableList(ladderPoleInfos);
        this.ladderLines = Collections.unmodifiableList(ladderLines);
    }

    public static LadderGameResultDto create(final LadderGame ladderGame) {
        return create(ladderGame.getLadderGameInfo(), ladderGame.getLadder());
    }

    public static LadderGameResultDto create(final LadderGameInfo ladderGameInfo, final Ladder ladder) {
        List<LadderPoleInfo> ladderPoleInfos = IntStream.range(ZERO, ladderGameInfo.count())
            .mapToObj(i -> LadderPoleInfo.create(ladderGameInfo.getMember(i), ladderGameInfo.getOriginLadderGameReword(i)))
            .collect(Collectors.toList());

        return new LadderGameResultDto(ladderPoleInfos, ladder.getLines());
    }

    public List<LadderPoleInfo> getLadderPoleInfos() {
        return new ArrayList<>(ladderPoleInfos);
    }

    public List<LadderLine> getLadderLines() {
        return new ArrayList<>(ladderLines);
    }
}
