class StringToNumberConverter {
    private int number1;
    private int number2;
    private boolean flagNumberOne = false;
    private boolean flagNumberTwo = false;

    public StringToNumberConverter(String str1, String str2) {
        parseNumber1(str1);
        parseNumber2(str2);
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void parseNumber1(String str1) {
        try {
            number1 = Integer.parseInt(str1);
            flagNumberOne = true;
        }catch (NumberFormatException e){
            number1 = new RomanToArabicConverter().convertToDecimal(str1);
        }
    }
    public void parseNumber2(String str2) {
        try {
            number2 = Integer.parseInt(str2);
            flagNumberTwo = true;
        }catch (NumberFormatException e){
            number2 = new RomanToArabicConverter().convertToDecimal(str2);
        }
    }
    public boolean checkFlags() {
        if (flagNumberOne && flagNumberTwo) return true;
        else if (!flagNumberOne && !flagNumberTwo) {
            return false;
        }else throw new RuntimeException("Используются одновременно разные системы счисления");
    }
}
