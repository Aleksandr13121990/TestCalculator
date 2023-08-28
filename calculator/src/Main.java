import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            line = bufferedReader.readLine();
        }
        System.out.println(calc(line));
    }
    public static String calc(String input) {
        int result;
        String[] expression = input.split(" ");
        Calculator calculator = new Calculator();
        if (expression.length > 3) {
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (expression.length == 1) {
            throw new RuntimeException("Строка не является математической операцией");
        }
        StringToNumberConverter stringToNumberConverter = new StringToNumberConverter(expression[0], expression[2]);


        switch (expression[1]) {
            case "+" :
                result = calculator.add(stringToNumberConverter.getNumber1(), stringToNumberConverter.getNumber2());
                if (stringToNumberConverter.checkFlags()) {
                    return String.valueOf(result);
                }else return new ArabicToRomanConverter().intToRoman(result);

            case "-" :
                result = calculator.subtract(stringToNumberConverter.getNumber1(), stringToNumberConverter.getNumber2());
                if (stringToNumberConverter.checkFlags()) {
                    return String.valueOf(result);
                }else if (result < 1) {
                    throw new RuntimeException("В римской системе результат не может быть меньше единицы");
                }else return new ArabicToRomanConverter().intToRoman(result);

            case "*" :
                result = calculator.multiply(stringToNumberConverter.getNumber1(), stringToNumberConverter.getNumber2());
                if (stringToNumberConverter.checkFlags()) {
                    return String.valueOf(result);
                }else return new ArabicToRomanConverter().intToRoman(result);

            case "/" :
                result = calculator.divide(stringToNumberConverter.getNumber1(), stringToNumberConverter.getNumber2());
                if (stringToNumberConverter.checkFlags()) {
                    return String.valueOf(result);
                }else if (result < 1) {
                    throw new RuntimeException("В римской системе результат не может быть меньше единицы");
                }else return new ArabicToRomanConverter().intToRoman(result);
            default:
                return null;
        }
    }
}