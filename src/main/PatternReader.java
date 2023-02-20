package main;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class PatternReader {

    public static void main(String[] args) {
        File patternFile = new File(Const.FILE_PATH, Const.FILE_NAME);
        List<Pattern> patterns = parsePattern(patternFile);
        if (patterns != null) {
            System.out.println("Done reading file. count is:" + patterns.size());
        }
    }

    public static List<Pattern> parsePattern(File patterFile) {
        if (patterFile == null) return null;
        JSONParser parser = new JSONParser();
        try {
            JSONArray patternArray = (JSONArray) parser.parse(readJsonFromFile(patterFile).toString());
            Type listType = new TypeToken<List<Pattern>>() {
            }.getType();
            return new Gson().fromJson(patternArray.toString(),
                    listType);
        } catch (Exception e) {
            System.out.println("Exception=" + e);
        }
        return null;
    }

    private static StringBuilder readJsonFromFile(File patternFile) {
        StringBuilder patternBuilder = null;
        if (patternFile.exists()) {
            patternBuilder = new StringBuilder();
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
        return patternBuilder;
    }
}
