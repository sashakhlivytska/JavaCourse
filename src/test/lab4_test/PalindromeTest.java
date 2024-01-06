import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @ParameterizedTest
    @ValueSource(strings = {"radar", "hannah", "pup", "nan", "eye", "6543456", "step on no pets"})
    void isPalindrome_Palindrome_ShouldReturnTrue(String palindrome) {
        assertTrue(Palindrome.isPalindrome(palindrome));
    }

    @ParameterizedTest
    @ValueSource(strings = {"banana", "lollipop", "A man a plan a canal Panama"})
    void isPalindrome_NotPalindrome_ShouldReturnFalse(String notPalindrome) {
        assertFalse(Palindrome.isPalindrome(notPalindrome));
    }

    @Test
    void isPalindrome_NullValue_ShouldReturnTrue() {
        assertTrue(Palindrome.isPalindrome(null));
    }
}
