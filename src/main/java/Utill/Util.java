/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author tuanb
 */
public class Util {

    private static Scanner sc = new Scanner(System.in);

    public static boolean isDateValid(String date) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date validDate = null;
        df.setLenient(false);
        try {
            validDate = df.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Date inputDate() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date now = null;
        Date today = new Date();
        today.getTime();
        String st = df.format(today);
        System.out.println("Please input expired date (Expiry date must be greater than today and correct format (dd-MM-yyy) : ");
        while (true) {

            String expiredDate = sc.nextLine();
            try {
                now = df.parse(expiredDate);
            } catch (ParseException ex) {
            }
            if (Util.isDateValid(expiredDate)) {
                if (now.compareTo(today) < 0) {
                    System.err.println("Expired food ! Input again: ");
                } else {
                    break;
                }
            } else {
                System.err.println("Invalid Day ! Input again: ");
            }
        }
        return now;
    }

    public static double inputDoubleNumber(double min, double max) {
        double result = min;
        while (true) {
            try {
                System.out.println("Please input the weight of the food (grams) :");
                Scanner sc = new Scanner(System.in);
                result = Double.parseDouble(sc.nextLine());
                if (result < min || result > max) {
                    System.err.println("Your weight input is not valid. Weight of food must be in range [0-10000] grams");
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Your weight input is not valid type. Please enter valid weight value again!");

            }
        }
    }

    public static String checkInputNameString() {
        String name;
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        System.out.println("Please input name of food (without numbers) : ");
        while (true) {
            name = sc.nextLine().toUpperCase();
            do {
                if (name == null || name.isEmpty() || name.isBlank()) {
                    System.err.println("The name of food cannot be blank or empty ! ");
                    name = sc.nextLine().toUpperCase();
                }
            } while (name.isEmpty() || name.isBlank());
            if (p.matcher(name).find()) {
                break;
            } else {
                System.err.println("Wrong input name! Name of food cannot have numbers and special characters  ! ");
            }
        }
        return name;
    }

    public static String checkInputIDString() {
        String ID;
        System.out.println("Please input ID of food : ");

        ID = sc.nextLine().toUpperCase();
        do {
            if (ID == null || ID.isEmpty() || ID.isBlank()) {
                System.err.println("The ID of food cannot be blank or empty ! ");
                ID = sc.nextLine().toUpperCase();
            }
        } while (ID.isEmpty() || ID.isBlank());
        return ID;
    }

    public static String checkReinputIDString() {
        String ID;

        ID = sc.nextLine().toUpperCase();
        do {
            if (ID == null || ID.isEmpty() || ID.isBlank()) {
                System.err.println("The ID of food cannot be blank or empty ! ");
                ID = sc.nextLine().toUpperCase();
            }
        } while (ID.isEmpty() || ID.isBlank());

        return ID;
    }

    public static String choosePlace() {
        System.out.println("Please choose place");
        System.out.println("1. Freezer ");
        System.out.println("2. Cooler ");
        System.out.println("Please input [1..2] : ");
        int choice = 0;
        String place = null;
        Boolean wrongInput = false;
        do {
            if (wrongInput) {
                System.out.println("Wrong input ! You are input text, or input the menu limit. Please input again ! ");
            }
            try {
                choice = 0;
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();
            } catch (Exception e) {
            }
            wrongInput = true;
        } while (choice < 1 || choice > 2);

        switch (choice) {
            case 1: {
                place = new String("Freezer");
                break;
            }
            case 2: {
                place = new String("Cooler");
                break;
            }
        }
        return place;
    }

    public static String chooseType() {
        System.out.println("Please choose type of food");
        System.out.println("1. Vegetables ");
        System.out.println("2. Fruits ");
        System.out.println("3. Grains, Beans and Nuts ");
        System.out.println("4. Meat and Poultry ");
        System.out.println("5. Fish and Seafood ");
        System.out.println("Please choose [1..5] : ");
        int choice = 0;
        String type = null;
        Boolean wrongInput = false;
        do {
            if (wrongInput) {
                System.out.println("Wrong input ! You are input text, or input the menu limit. Please input again ! ");
            }
            try {
                choice = 0;
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();
            } catch (Exception e) {
            }
            wrongInput = true;
        } while (choice < 1 || choice > 5);

        switch (choice) {
            case 1: {
                type = new String("Vegetables");
                break;
            }
            case 2: {
                type = new String("Fruits");
                break;
            }
            case 3: {
                type = new String("Grains, Beans and Nuts");
                break;
            }
            case 4: {
                type = new String("Meat and Poultry");
                break;
            }
            case 5: {
                type = new String("Fish and Seafood");
                break;
            }
            default: {
                break;
            }
        }
        return type;

    }

}
