package ladder.view;

public enum SearchType {
    ALL("ALL");

    private final String searchType;

    SearchType(String searchType) {
        this.searchType = searchType;
    }

    public boolean equalsSearchType(String searchType) {
        return this.searchType.equals(searchType);
    }
}
