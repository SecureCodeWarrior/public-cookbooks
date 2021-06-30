package annotations.disabledreason;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;

class DisabledWithoutReasonTest {

    /*
    Try This...

    Instead of allowing @Disabled annotations with no description, create a recipe
    that adds a placemarker comment.

    Note:
    - checkstyle Google and Sun checks allow @Disabled
    - SonarLint flags this as an issue but docs currently show examples for Junit4 rather than Junit 5

    We want:

    - `@Disabled("TODO: add a description here")`

    Create a recipe:

    - Which finds all `@Disabled` annotations with no parameters
    - With an associated quick fix which amends
    the annotation to have "TODO: add a description here" as the parameter

 */

    @Disabled
    void thisTestMethodHasNoDisabledReason(){
        Assertions.fail("This test is disabled so should not run and we won't fail");
    }

    @Disabled("I have a reason")
    void thisTestMethodHasDisabledReason(){
        Assertions.fail("This test is disabled so should not run and we won't fail");
    }
}
