package step1.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step1.domain.Line;

public class LineDto {

    private final List<BridgeDto> bridges = new ArrayList<>();
    private final int height;

    public LineDto(List<BridgeDto> bridges, int height) {
        this.bridges.addAll(bridges);
        this.height = height;
    }

    public static LineDto from(Line line) {
        List<BridgeDto> bridges = line.getBridges().stream()
            .map(BridgeDto::from)
            .collect(Collectors.toList());
        return new LineDto(bridges, line.getHeight());
    }

    public List<BridgeDto> getBridges() {
        return bridges;
    }

    public int getHeight() {
        return height;
    }
}
