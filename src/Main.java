import java.util.Scanner;

public class Main {
    public static String SPACE_SYMBOL = "-";
    public static String FIGURE_SYMBOL = "*";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        
        while (n % 2 == 0 || (n <= 2 || n > 9999)) {
            System.out.println("Unexpected value found! Please enter an ODD number 2 < N < 10000: ");
            n = Integer.parseInt(input.nextLine());
        }
        
        int figureHeight = n + 1;
        int figureHalf = figureHeight / 2;
        int halfOfN = n / 2;
        
        //upper part
        for (int i = n, j = 0; i >= figureHalf; i--, j++) {
            String leftHalf = repeatString(SPACE_SYMBOL, i) +
                    repeatString(FIGURE_SYMBOL, n + j) +
                    repeatString(FIGURE_SYMBOL, j) +
                    repeatString(SPACE_SYMBOL, halfOfN - j) + "-";
            
            String rightHalf = reverseString(leftHalf);
            System.out.println(repeatString(leftHalf + rightHalf,2));
        }

        //bottom part
        for (int i = figureHalf, j = 0; i > 0; i--, j++) {
            String leftHalf = repeatString(SPACE_SYMBOL, halfOfN-j) +
                    repeatString(FIGURE_SYMBOL, n ) +
                    repeatString(SPACE_SYMBOL, j) +
                    "-"+
                    repeatString(SPACE_SYMBOL,  j) +
                    repeatString(FIGURE_SYMBOL,  n-j-1) +"*";
            String rightHalf = reverseString(leftHalf);
            System.out.println(repeatString(leftHalf + rightHalf,2));
        }


    }


    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static String repeatString(String str, int count) {
        StringBuilder seq = new StringBuilder();
        for (int i = 0; i < count; i++) {
            seq.append(str);
        }
        return seq.toString();
    }
}
