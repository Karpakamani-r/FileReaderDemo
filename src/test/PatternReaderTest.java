package test;

import main.Pattern;
import main.PatternReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class PatternReaderTest {

    private static final String VALID_JSON_FILE = "C:\\Users\\karpakamani.r\\IdeaProjects\\ReadJson\\src\\test\\testValidPattern.json";
    private static final String INVALID_JSON_FILE = "C:\\Users\\karpakamani.r\\IdeaProjects\\ReadJson\\src\\test\\testInvalidPattern.json";
    private static final String INVALID_JSON_FILE_PATH = "C:\\Users\\karpakamani.r\\IdeaProjects\\ReadJson\\src\\test\\pattern.json";

    @Test
    void testPatternParsingWithValidJson() {
        //Given Valid Json Format
        File file = new File(VALID_JSON_FILE);
        //Parsing File
        List<Pattern> result = PatternReader.parsePattern(file);
        //List of pattern will be received
        Assertions.assertEquals(result, result);
    }

    @Test
    void testPatternParsingWithInValidJson() {
        //Given In Valid Json Format
        File file = new File(INVALID_JSON_FILE);
        //Parsing File
        List<Pattern> result = PatternReader.parsePattern(file);
        //Null will be returned
        Assertions.assertNull(result);
    }

    @Test
    void testPatternParsingWithInEmptyJson() {
        //Given In Valid File Path
        File file = new File(INVALID_JSON_FILE_PATH);
        //Parsing File, Null should be return
        List<Pattern> result = PatternReader.parsePattern(file);
        Assertions.assertNull(result);
    }
}