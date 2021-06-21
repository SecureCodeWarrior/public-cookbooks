import javax.el.*;
import java.io.IOException;
import java.util.Scanner;

public class EL_Injection {

    public static void main(String[] args) {
        ExpressionFactory el = ExpressionFactory.newInstance();
        ELContext elContext = new StandardELContext(el);
        el.createValueExpression(elContext, args[1], Object.class);
    }

    public static void expressionRecipes() throws IOException {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        ExpressionFactory el = ExpressionFactory.newInstance();
        ELContext elContext = new StandardELContext(el);
        el.createValueExpression(elContext, expression, ValueExpression.class);
    }
}
