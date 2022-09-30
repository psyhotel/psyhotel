import java.util.*;

class Calc {
    static Scanner scanner = new Scanner(System.in);

    static String convertNumToRoman(int numArabian) {
        return RomainDigits.valueOf(numArabian);
    }

    public static void calc(Scanner input) {
        int num1 = 0, num2 = 0;
        String operand = "";
        String[] str;
        boolean isRoman = false;
        if (input.hasNextInt()) {
            str = input.nextLine().split(" ");
            if (str.length < 3) {
                throw new RuntimeException("Строка не является математической операцией");
            }
            if (str.length > 3) {
                throw new RuntimeException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            num1 = Integer.parseInt(str[0]);
            operand = str[1];
            try {
                num2 = Integer.parseInt(str[2]);

            } catch (Exception e) {
                throw new NumberFormatException("Ошибка: ");
            }
        } else {
            str = input.nextLine().split(" ");

            try {
                num1 = romanToNumber(str[0]);
                operand = str[1];
                num2 = romanToNumber(str[2]);
                isRoman = true;
            } catch (Exception exception) {
                throw new NumberFormatException("Ошибка: ");
            }

        }

        if (str.length > 3) {
            throw new RuntimeException("Больше двух операндов");
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
            throw new WrongSignException(operand + " ");
        }

        if (isRoman && results < 0) {
            throw new RuntimeException("в римской системе нет отрицательных чисел");
        }
        if ((isRoman) && results == 0) {
            throw new RuntimeException("В римской системе счисления не может быть 0");
        }

        if (isRoman) {
            System.out.println(convertNumToRoman(results));
        } else {
            System.out.println(results);
        }

    }

    static int romanToNumber(String roman) {
        return RomainDigits.indexOf(roman);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение от 1 до 10 арабскими числами [2 - 2] или римскими числами [II + V]");
        calc(scanner);
    }
}