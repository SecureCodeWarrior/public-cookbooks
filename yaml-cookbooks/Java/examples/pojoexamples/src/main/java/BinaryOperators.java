public class BinaryOperators
{
    public boolean performLogicalANDOperation(boolean a, boolean b) {
        return a && b;
    }

    public boolean performBitwiseANDOperation(boolean a, boolean b) {
        return a & b;
    }

    public String performLogicalStringANDOperation() {
        return "a && b";
    }

    public String performBitwiseStringANDOperation() {
        return "a & b";
    }

    public Boolean performWrappedLogicalANDOperation (Boolean a, Boolean b) {
        return a && b;
    }

    public Boolean performWrappedBitwiseANDOperation (Boolean a, Boolean b) {
        return a & b;
    }

    public boolean performLogicalOROperation(boolean a, boolean b) {
        return a || b;
    }

    public boolean performBitwiseOROperation(boolean a, boolean b) {
        return a | b;
    }

    public String performLogicalStringOROperation() {
        return "a || b";
    }

    public String performBitwiseStringOROperation() {
        return "a | b";
    }

    public Boolean performWrappedLogicalOROperation(Boolean a, Boolean b) {
        return a || b;
    }

    public Boolean performWrappedBitwiseOROperation(Boolean a, Boolean b) {
        return a | b;
    }

    public void test() {
        if (performWrappedBitwiseOROperation(true, false)){
            System.out.println("In if");
        } else {
            System.out.println("In else");
        }

        if (true|false) {
            System.out.println();
        }
    }
}
