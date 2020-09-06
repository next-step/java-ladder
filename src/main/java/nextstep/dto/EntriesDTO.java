package nextstep.dto;

import nextstep.entity.Entries;
import nextstep.entity.Entry;

import java.util.List;
import java.util.stream.Collectors;

public class EntriesDTO implements DTO {

    private final List<EntryDTO> entries;

    public EntriesDTO(List<EntryDTO> entries) {
        this.entries = entries;
    }

    public Entries of() {
        List<Entry> entries = this.entries.stream()
                .map(EntryDTO::of)
                .collect(Collectors.toList());
        return new Entries(entries);
    }
}
