package nextstep.dto;

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
}
