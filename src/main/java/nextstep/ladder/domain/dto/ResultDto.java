package nextstep.ladder.domain.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultDto {
    private final Map<String, Integer> playerInfos;
    private final List<RowDto> rows;
    private final List<String> endpoints;

    private ResultDto(final Map<String, Integer> playerInfos, final List<RowDto> rows, final List<String> endpoints) {
        this.playerInfos = playerInfos;
        this.rows = rows;
        this.endpoints = endpoints;
    }

    public static ResultDto of(final Map<String, Integer> playerInfos, final List<RowDto> rows, final List<String> endpoints) {
        return new ResultDto(playerInfos, rows, endpoints);
    }

    public Set<String> getNames() {
        return playerInfos.keySet();
    }

    public Integer getPosition(final String name) {
        return playerInfos.get(name);
    }

    public List<RowDto> getRows() {
        return rows;
    }

    public List<String> getEndpoints() {
        return endpoints;
    }

    public String getEndpoint(final int position) {
        return endpoints.get(position);
    }
}
