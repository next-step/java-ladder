package nextstep.ladder.controller;


public class Query {

    private static final String GAME_END_QUERY = "all";
    private static final String ALL_QUERY = "all";

    private final String query;

    public Query(String query) {
        this.query = query;
    }

    public boolean isNotEndQuery() {
        return !query.equals(GAME_END_QUERY);
    }

    public String query() {
        return query;
    }

    public boolean isAll() {
        return query.equals(ALL_QUERY);
    }
}
