package gotchas.bitwiseoperators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConditionsTest {

    /*
 logical operators:

 - && and || only work on boolean statements
 - and are short circuit operators in that only those necessary to evaluate the boolean expression are evaluated
   in the case of &&, the evaluation stops at the first false statement

 bitwise operators:

 - work on booleans accurately
 - but do not short circuit the evalution
 - their use in a conditional statement is 'probably' a mistake
 - and in some cases, can lead to errors
*/

    @Test
    void bitwiseOperatorsAndTruthTable(){
        Assertions.assertEquals(true, true & true);
        Assertions.assertEquals(false, true & false);
        Assertions.assertEquals(false, false & true);
        Assertions.assertEquals(false, false & false);
    }

    @Test
    void bitwiseOperatorsOrTruthTable(){
        Assertions.assertEquals(true, true | true);
        Assertions.assertEquals(true, true | false);
        Assertions.assertEquals(true, false | true);
        Assertions.assertEquals(false, false | false);
    }


    // this if statement would 'work' as intended if && was used

    @Test
    void butProblematicOnOtherValuesWhenUsedInIfStatements(){

        String args = null;

        Assertions.assertThrows(NullPointerException.class, () ->{
            actOnArgs(args);
        });
    }

    void actOnArgs(String args){
        if (args != null & args.length() > 23) {
            System.out.println(args);
        }
    }

    @Test
    void evenWhenBitwiseOperatorsNormallyUsed(){

        String intent = null;

        Assertions.assertThrows(NullPointerException.class, () -> {
            Boolean empty = intent != null & intent.isEmpty();
        });
    }
    
}
