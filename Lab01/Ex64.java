import java.util.Scanner;

public class Ex64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        while (check == false) {
            System.out.print("Nhap nam: ");
            int year = sc.nextInt();
            System.out.print("Nhap thang: ");
            int month = sc.nextInt();

            if (year < 0 || 1 > month || 12 < month) {
                System.out.println("Invalid Input");
            } else {
                check = true;
                if (month == 1) {
                    System.out.println(31);
                } else if (month == 3) {
                    System.out.println(31);
                } else if (month == 4) {
                    System.out.println(30);
                } else if (month == 5) {
                    System.out.println(31);
                } else if (month == 6) {
                    System.out.println(30);
                } else if (month == 7) {
                    System.out.println(31);
                } else if (month == 8) {
                    System.out.println(31);
                } else if (month == 9) {
                    System.out.println(30);
                } else if (month == 10) {
                    System.out.println(31);
                } else if (month == 11) {
                    System.out.println(30);
                } else if (month == 12) {
                    System.out.println(31);
                } else {
                    if (year % 4 != 0) {
                        System.out.println(28);
                    } else {
                        if (year % 100 == 0 && year % 400 != 0) {
                            System.out.println(28);
                        } else {
                            System.out.println(29);
                        }
                    }
                }
            }
        }

        sc.close();
        System.exit(0);
    }
}