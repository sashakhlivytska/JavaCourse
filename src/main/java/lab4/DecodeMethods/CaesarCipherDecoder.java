import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CaesarCipherDecoder implements Decoder {
    private final List<Character> cipherAlphabet;
    private final Map<Character, Character> cipherCodes;
    private final Pattern encodedTestPattern;

    public CaesarCipherDecoder(List<Character> cipherAlphabet) {
        this.cipherAlphabet = new ArrayList<>(cipherAlphabet);
        cipherCodes = cipherAlphabet.stream().collect(Collectors.toMap(
                consonant -> getNextConsonant(consonant),
                consonant -> consonant
        ));
        encodedTestPattern = compileTestPattern();
    }
    private char getNextConsonant(char consonant) {
        int index = (cipherAlphabet.indexOf(consonant) + 1) % cipherAlphabet.size();
        return cipherAlphabet.get(index);
    }

    public String decode(String word) {
        StringBuilder builder = new StringBuilder();
        word.chars().forEach(charCode -> {
            char character = (char) charCode;
            builder.append(cipherCodes.getOrDefault(character, character));
        });
        return builder.toString();
    }

    public boolean isEncoded(String word) {
        return encodedTestPattern.matcher(word).matches();
    }

    private Pattern compileTestPattern() {
        StringBuilder builder = new StringBuilder();
        builder.append(".*[");
        cipherAlphabet.forEach(builder::append);
        builder.append("]+.*");
        return Pattern.compile(builder.toString());
    }
}
