public class NUM08J_FloatExceptionalValues {
    double currentBalance; // User's cash balance

    void doDepositBad(String userInput) {
        double val = 0;
        try {
            val = Double.valueOf(userInput);
        } catch (NumberFormatException e) {
            // Handle input format error
        }

        if (val >= Double.MAX_VALUE - currentBalance) {
            // Handle range error
        }

        currentBalance += val;
    }

    void doDepositGood(String userInput){
        double val = 0;
        try {
            val = Double.valueOf(userInput);
        } catch (NumberFormatException e) {
            // Handle input format error
        }

        if (Double.isInfinite(val)){
            // Handle infinity error
        }

        if (Double.isNaN(val)) {
            // Handle NaN error
        }

        if (val >= Double.MAX_VALUE - currentBalance) {
            // Handle range error
        }
        currentBalance += val;
    }
}
