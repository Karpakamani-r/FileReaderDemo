import java.io.File;
import java.nio.file.Paths;

public class Const {
    public static class KEY {
        static final String TABLE_NAME = "table_name";
        static final String DB_NAME = "db_name";
        static final String PATTERN = "pattern";
        static final String SQL = "sql";
    }

    static final String FILE_PATH = new File(Paths.get(".").normalize().toAbsolutePath() + "/src/").toString();
    static final String FILE_NAME = "data.json";
}
