package nextstep.ladder;

import nextstep.ladder.domain.BridgeGenerator;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResultDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderGame {
    private final int height;
    private final List<Line> lines;
    private final List<Player> players;

    public LadderGame(LadderRequestDto ladderRequestDto, BridgeGenerator bridgeGenerator) {
        this.height = ladderRequestDto.getHeight();
        this.players = this.generatePlayers(ladderRequestDto);
        this.lines = this.generateLines(ladderRequestDto, bridgeGenerator);
    }

    private List<Player> generatePlayers(LadderRequestDto ladderRequestDto) {
        return ladderRequestDto.getNames()
                .stream()
                .map(Player::new)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    private List<Line> generateLines(LadderRequestDto ladderRequestDto, BridgeGenerator bridgeGenerator) {
        List<Line> lines = new ArrayList<>();
        int countOfPerson = ladderRequestDto.getNames().size();
        for (int i = 0; i < this.height; i++) {
            lines.add(new Line(countOfPerson, bridgeGenerator));
        }
        return Collections.unmodifiableList(lines);
    }

    public LadderResultDto getLadderResult() {
        return new LadderResultDto(this.players, this.lines);
    }
}
