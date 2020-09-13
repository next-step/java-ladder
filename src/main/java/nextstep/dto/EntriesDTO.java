package nextstep.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EntriesDTO implements DTO {

    private final List<EntryDTO> entries;

    public EntriesDTO(List<EntryDTO> entries) {
        validate(entries);
        this.entries = entries;
    }

    private void validate(List<EntryDTO> entries) throws IllegalArgumentException {
        Set<EntryDTO> set = new HashSet<>(entries);
        if (set.size() != entries.size()) {
            throw new IllegalArgumentException("중복된 이름이 있어요.");
        }
    }

    public List<String> getEntryNames() {
        return this.entries.stream()
                .map(EntryDTO::getName)
                .collect(Collectors.toList());
    }

    public int getEntryCount() {
        return this.entries.size();
    }

    public List<EntryDTO> getEntries() {
        return this.entries;
    }

    public static EntriesDTO duplicate(EntriesDTO entriesDTO) {
        List<EntryDTO> duplicated = entriesDTO.entries.stream()
                .map(EntryDTO::duplicate)
                .collect(Collectors.toList());
        return new EntriesDTO(duplicated);
    }

    public boolean hasEntry(EntryDTO targetEntry) {
        return entries.stream()
                .anyMatch(entryDTO -> entryDTO.equals(targetEntry));
    }
}
