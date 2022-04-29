package nextstep.ladder.view.dto;

import nextstep.ladder.model.Name;
import nextstep.ladder.model.Names;

import java.util.List;
import java.util.stream.Collectors;

public final class NameResponse {

    private final String name;

    private NameResponse(String name) {
        this.name = name;
    }

    public static List<NameResponse> listFrom(Names names) {
        return names.list()
                .stream()
                .map(NameResponse::from)
                .collect(Collectors.toList());
    }

    private static NameResponse from(Name name) {
        return new NameResponse(name.value());
    }

    public String getName() {
        return name;
    }
}
