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

    public List<String> getEntryNames() {
        return this.entries.stream()
                .map(EntryDTO::getName)
                .collect(Collectors.toList());
    }

    public int getEntryCount() {
        return this.entries.size();
    }

    public static Entries of(EntriesDTO entriesDTO) {
        List<Entry> entries = entriesDTO.entries.stream()
                .map(EntryDTO::of)
                .collect(Collectors.toList());
        return new Entries(entries);
    }
}
