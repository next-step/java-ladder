package ladder.domain.model;

public enum SearchType {
    ALL("ALL");

    private final String searchType;

    SearchType(String searchType) {
        this.searchType = searchType;
    }

    public boolean equals(String searchType) {
        return this.searchType.equals(searchType);
    }

    public boolean notEquals(String searchType) {
        return !this.searchType.equals(searchType);
    }
}
