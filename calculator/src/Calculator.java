 class Calculator {
     public int add(int number1, int number2) {
         boolean x = checkNumberInRange(number1, number2);
         return number1 + number2;
     }
     public int subtract(int number1, int number2) {
         boolean x = checkNumberInRange(number1, number2);
         return number1 - number2;
     }
     public int multiply(int number1, int number2) {
         boolean x = checkNumberInRange(number1, number2);
         return number1 * number2;
     }
     public int divide(int number1, int number2) {
         boolean x = checkNumberInRange(number1, number2);
         return number1 / number2;
     }
     public boolean checkNumberInRange(int number1, int number2) {
         if ((number1 >= 1 && number1 <= 10) && (number2 >= 1 && number2 <= 10)) return true;
         else {
             throw new RuntimeException("Число меньше единицы или больше десяти!!!");
         }
     }
}
