import java.util.Scanner;

public class Ex64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        while (!check) {
            System.out.print("Nhap nam: ");
            int year = sc.nextInt();
            sc.nextLine();

            System.out.print("Nhap thang: ");
            String monthStr = sc.nextLine().trim().toLowerCase();

            if (monthStr.endsWith(".")) {
                monthStr = monthStr.substring(0, monthStr.length() - 1);
            }

            int month = -1;
            switch (monthStr) {
                case "1":
                case "january":
                case "jan.":
                case "jan":
                    month = 1;
                    break;
                
                case "2":
                case "february":
                case "feb.":
                case "feb":
                    month = 2;
                    break;

                case "3":
                case "march":
                case "mar.":
                case "mar":
                    month = 3;
                    break;

                case "4":
                case "april":
                case "apr.":
                case "apr":
                    month = 4;
                    break;

                case "5":
                case "may":
                case "may.":
                    month = 5;
                    break;

                case "6":
                case "june":
                case "jun.":
                case "jun":
                    month = 6;
                    break;

                case "7":
                case "july":
                case "jul.":
                case "jul":
                    month = 7;
                    break;

                case "8":
                case "august":
                case "aug.":
                case "aug":
                    month = 8;
                    break;

                case "9":
                case "september":
                case "sep.":
                case "sep":
                    month = 9;
                    break;

                case "10":
                case "october":
                case "oct.":
                case "oct":
                    month = 10;
                    break;

                case "11":
                case "november":
                case "nov.":
                case "nov":
                    month = 11;
                    break;

                case "12":
                case "december":
                case "dec.":
                case "dec":
                    month = 12;
                    break;

                default:
                    month = -1;
            }

            if (year < 0 || month == -1) {
                System.out.println("Invalid Input");
            } else {
                check = true;
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        System.out.println(31);
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        System.out.println(30);
                        break;
                    case 2:
                        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                            System.out.println(29);
                        } else {
                            System.out.println(28);
                        }
                        break;
                }
            }
        }

        sc.close();
        System.exit(0);
    }
}