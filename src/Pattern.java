import com.google.gson.annotations.SerializedName;

public class Pattern {
    @SerializedName("table_name")
    private String tableName;
    @SerializedName("db_name")
    private String dbName;
    @SerializedName("pattern")
    private String pattern;
    @SerializedName("sql")
    private String sql;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
