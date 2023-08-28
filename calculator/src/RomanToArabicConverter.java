import java.util.HashMap;
import java.util.Map;

class RomanToArabicConverter {
    private static final Map<Character, Integer> ROMAN_NUMERALS = new HashMap<>();

    static {
        ROMAN_NUMERALS.put('I', 1);
        ROMAN_NUMERALS.put('V', 5);
        ROMAN_NUMERALS.put('X', 10);
        ROMAN_NUMERALS.put('L', 50);
        ROMAN_NUMERALS.put('C', 100);
        ROMAN_NUMERALS.put('D', 500);
        ROMAN_NUMERALS.put('M', 1000);
    }
    private String romanNumeral;

    public String getRomanNumeral() {
        return romanNumeral;
    }

    public void setRomanNumeral(String romanNumeral) {
        this.romanNumeral = romanNumeral;
    }
    public int convertToDecimal(String romanNumeral) {
        this.romanNumeral = romanNumeral;
        int arabicNumber = 0;
        int previousValue = 0;

        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char currentRomanDigit = romanNumeral.charAt(i);
            int currentValue = ROMAN_NUMERALS.get(currentRomanDigit);
            if (currentValue < previousValue) {
                arabicNumber -= currentValue;
            }else {
                arabicNumber+= currentValue;
                previousValue = currentValue;
            }
        }
        return arabicNumber;
    }
}
