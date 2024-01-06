import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class JavaDecoderTest {

    @ParameterizedTest
    @ValueSource(strings = {"t2st", "epdofef", "t2xt", "xivj", "b4th", "nevjoft"})
    void isEncoded_ShouldReturnTrueForEncodedWord(String encodedWord) {
        assertTrue(JavaDecoder.isEncoded(encodedWord));
    }

    @ParameterizedTest
    @CsvSource({"t2st,test", "616,yay", "f44,foo", "123456,aeiouy"})
    void decode_VowelEncodedWord_ShouldReturnDecoded(String encodedWord, String expected) {
        assertEquals(expected, JavaDecoder.decode(encodedWord));
    }

    @ParameterizedTest
    @CsvSource({"vetv,test", "yay,yay", "goo,foo", "cdfghjklmnpqrstvwxzb,bcdfghjklmnpqrstvwxz"})
    void decode_ConsonantEncodedWord_ShouldReturnDecoded(String encodedWord, String expected) {
        assertEquals(expected, JavaDecoder.decode(encodedWord));
    }

    @ParameterizedTest
    @CsvSource({
            "s4m2 2nc4d2d t2xt w3th m2th4d f4r v4w2ls,some encoded text with method for vowels",
            "tone epdofef vezv xivj nevjof gos doptopapvt,some encoded text with method for consonants",
            "s4m2 epdofef t2xt xivj b4th nevjoft,some encoded text with both methods"
    })
    void decodeText_ShouldReturnDecodedText(String encodedText, String expected) {
        assertEquals(expected, JavaDecoder.decodeText(encodedText));
    }
}
