package ladder.nextstep;

import ladder.engine.Ladder;
import ladder.engine.LadderRepository;
import ladder.engine.Line;
import ladder.engine.LineRepository;

import java.util.ArrayList;
import java.util.List;

public class NextStepLadderRepository implements LadderRepository {
    private LineRepository lineRepository;

    public NextStepLadderRepository(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @Override
    public Ladder create(int countOfPersion, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(lineRepository.create(countOfPersion));
        }
        System.out.println("Line : " + lines);
        return new NextStepLadder(countOfPersion, lines);
    }
}
