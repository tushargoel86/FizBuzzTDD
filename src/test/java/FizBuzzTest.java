import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizBuzzTest {

    private FizBuzz fizBuzz;

    @BeforeEach
    void setup() {
        fizBuzz = new FizBuzz();
    }

    @DisplayName("Should return Fizz when input is 12")
    @Test
    void ShouldReturnFiz2() {
        shouldEvaluateInput(12, "Fiz");
    }

    @DisplayName("Should return Fiz when input is 9")
    @Test
    void ShouldReturnFizMultiple() {
        shouldEvaluateInput(9, "Fiz");
    }

    @DisplayName("Should return Buzz when input is 25")
    @Test
    void ShouldReturnBuzzMultiple() {
        shouldEvaluateInput(25, "Buzz");
    }

    @DisplayName("Should return FizBuzz when input is multiple of 15")
    @Test
    void ShouldReturnFizBuzz() {
        shouldEvaluateInput(15, "FizBuzz");
        shouldEvaluateInput(45, "FizBuzz");
    }

    @DisplayName("Should throw exception when input is neither multiple of 3 or 5")
    @Test
    void testForInvalidInput() {
        assertThrows(InvalidInputException.class, () -> fizBuzz.evaluate(2));
    }

    @DisplayName("Should throw exception message when input is neither multiple of 3 or 5")
    @Test
    void testForInvalidInputMessage() {
        shouldEvaluateInput(2, "");
    }

    void shouldEvaluateInput(int input, String result) {
        try {
            String actual = fizBuzz.evaluate(input);
            assertEquals(result, actual);
        } catch (InvalidInputException e) {
            assertEquals("Input is not multiple of 3 or 5", e.getMessage());
        }
    }
}
