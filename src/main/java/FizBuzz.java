import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FizBuzz {

    public String evaluate(int no) {
        if (!isValidInput(no)) {
            throw new InvalidInputException("Input is not multiple of 3 or 5");
        }
        List<Expression> expressionList = prepareExpressionList(no);
        return evaluateFizBuzz(expressionList);
    }

    private List<Expression> prepareExpressionList(int no) {
        List<Expression> expressionList = new ArrayList<>();
        if (no % 3 == 0) expressionList.add(new FizExpression());
        if (no % 5 == 0) expressionList.add(new BuzExpression());
        return expressionList;
    }

    private String evaluateFizBuzz(List<Expression> expressions) {
        return expressions.stream()
                .map(Expression::evaluate)
                .collect(Collectors.joining());
    }

    private boolean isValidInput(int no) {
        return isAMultiple(no, 3) || isAMultiple(no, 5);
    }

    private boolean isAMultiple(int no, int i) {
        return no % i == 0;
    }
}
