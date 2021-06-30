package annotations.documentationlinks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class JunitDocumentationLinkedTest {

    /**
     * @see <a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations">Junit 5 Annotation docs</a>
     */
    @Test
    void whatDoesTestDo(){

    }

    @ParameterizedTest
    @ValueSource(strings = {"secure", "code", "warrior"})
    void wordLengthMustBeGreaterThanThree(String word) {
        Assertions.assertTrue(word.length()>3,
                word + " length should be greater than 3");
    }
}
