package JavaSwingEg;

public class CalculatorToken {
    String token;
    TokenType tokenType;

    public CalculatorToken(String token, TokenType tokenType){
        this.token = token;
        this.tokenType = tokenType;
    }
}

enum TokenType{
    DIGIT, OPERATORS, RESULT
}
