import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseTextTest {

    @Test
    void getNumberFromText() {
        assertEquals(12,new ParseText().getNumberFromText("twelve"));
    }
}