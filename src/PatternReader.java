import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;
import java.util.stream.Stream;

public class PatternReader {

    public static void main(String[] args) {
        parsePattern();
    }

    private static void parsePattern() {
        JSONParser parser = new JSONParser();
        try {
            JSONObject patternJson = (JSONObject) parser.parse(readJsonFromFile());
            Stream sortedStream = patternJson.keySet().stream().sorted();
            Iterator iterator = sortedStream.iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                Pattern pattern = new Gson().fromJson(patternJson.get(key).toString(),
                        Pattern.class);
                uploadPattern(pattern);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static void uploadPattern(Pattern pattern) {
        System.out.println(pattern.getTableName());
    }

    private static String readJsonFromFile() {
        File patternFile = new File(Const.FILE_PATH, Const.FILE_NAME);
        StringBuilder patternBuilder = new StringBuilder();
        if (patternFile.exists()) {
            try (Reader input = new FileReader(patternFile)) {
                String line;
                // Checks if reader is ready
                BufferedReader br = new BufferedReader(input);
                while ((line = br.readLine()) != null) {
                    patternBuilder.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return patternBuilder.toString();
    }
}
