import java.util.*;

class Calc {
    static Scanner scanner = new Scanner(System.in);

    static String convertNumToRoman(int numArabian) {
        return RomainDigits.valueOf(numArabian);
    }

    static int romanToNumber(String roman) {
        return RomainDigits.indexOf(roman);
    }

    public static void calc(Scanner input) {
        int num1 = 0, num2 = 0;
        String operand = "";
        String[] str;
        char ch = 0;
        boolean isRoman;
        if (input.hasNextInt()) {
            str = input.nextLine().split(" ");
            num1 = Integer.parseInt(str[0]);
            operand = str[1];
            num2 = Integer.parseInt(str[2]);
            isRoman = false;
        } else {
            str = input.nextLine().split(" ");
            try {
                num1 = romanToNumber(str[0]);
                operand = str[1];
                num2 = romanToNumber(str[2]);
                isRoman = true;
            }catch (Exception exception){
                throw new CalculatorNumberFormatException("rrrrrоперанд 1 " + num1 + " оператор " + operand +  " операнд 2" + num2);
            }

        }
        int results = 0;
        if (num1 > 10 || num2 > 10) {
            throw new RuntimeException("Число больше 10");
        }
        if (Objects.equals(operand, "+")) {
            results = num1 + num2;
        } else if (Objects.equals(operand, "-")) {
            results = num1 - num2;
        } else if (Objects.equals(operand, "*")) {
            results = num1 * num2;
        } else if (Objects.equals(operand, "/")) {
            results = num1 / num2;
        } else {
            throw new WrongSignException("неверный оператор ---> " + operand);
        }

        if (isRoman) {
            System.out.println(convertNumToRoman(results));
        } else {
            System.out.println(results);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение от 1 до 10 арабскими числами [2 - 2] или римскими числами [II + V]");
        calc(scanner);
    }
}