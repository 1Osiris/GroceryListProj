import java.util.Scanner;
// Leighton Borgmann Julian Matthews
// Due: 4/15/2022
// Purpose: create a grocery list
import java.util.ArrayList;
public class Runtime {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        List list = new List();
        showMainMenu(list);
//input validate everything!!!!
    }
    public static void showMainMenu(List list){
        int dummy = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Here is your list so far:");
        list.printList();
        System.out.println("Which action would you like to preform?" +
                " (Type \"swap\" to swap, \"shift item\" to shift an item," +
                " \"remove\" to remove an item, \"add\" to add an item," +
                " \"sort\" to sort by aisle, or \"exit\" to exit.)");
        System.out.println("Case matters and failure to type a valid option" +
                " will either be treated as an exit or return you to the console.");
        String determinedAction = sc.nextLine(); // need sum input validation
        for (int i =0; i < determinedAction.length(); i++) {
            if (determinedAction.charAt(i) == 32) {
            } else if (determinedAction.charAt(i) >=65 && determinedAction.charAt(i) <=90){
            } else if (determinedAction.charAt(i) >= 97 && determinedAction.charAt(i) <= 122) {
            } else if (determinedAction.charAt(i) >=48 && determinedAction.charAt(i) <=57) {
            } else {
                showMainMenu(list);
            }
        }
        if (determinedAction.equals("swap")){
            System.out.println("What is the first item you want to swap?");

            String firstItemToBeSwapped = sc.nextLine();
            if (validateInt(firstItemToBeSwapped) > (list.shopList.size()) || validateInt(firstItemToBeSwapped) < 1 ){
                System.out.println("Invalid number.");
                showMainMenu(list);
            }
            System.out.println("What is the second item you want to swap?");
            String secondItemToBeSwapped = sc.nextLine();
            if (validateInt(secondItemToBeSwapped) > (list.shopList.size()) || validateInt(secondItemToBeSwapped) < 1 ){
                System.out.println("Invalid number.");
                showMainMenu(list);
            }
            list.swapItem(validateInt(firstItemToBeSwapped), validateInt(secondItemToBeSwapped));
            showMainMenu(list);
        } else if (determinedAction.equals("shift item")){
            System.out.println("What was the original position?");
            String ogPos = sc.nextLine();
            if (validateInt(ogPos) > (list.shopList.size()) || validateInt(ogPos) < 1 ){
                System.out.println("Invalid number.");
                showMainMenu(list);
            }
            System.out.println("What do you want its new position to be?");
            String newPos = sc.nextLine();
            if (validateInt(newPos) > (list.shopList.size()) || validateInt(newPos) < 1 ){
                System.out.println("Invalid number.");
                showMainMenu(list);
            }
            list.shiftItem(validateInt(ogPos), validateInt(newPos));
            showMainMenu(list);
        }else if (determinedAction.equals("remove")){
            System.out.println("Which number on the list do you want to remove?");
            String itemToBeRemoved = sc.nextLine();
            if (validateInt(itemToBeRemoved) > (list.shopList.size()) || validateInt(itemToBeRemoved) < 1 ){
                System.out.println("Invalid number.");
                showMainMenu(list);
            }
            list.removeOffOfList(validateInt(itemToBeRemoved));
            showMainMenu(list);
        } else if (determinedAction.equals("add")){
            System.out.println("What is the name of the item?");
            String newItemName = sc.nextLine();
            for (int j =0; j < newItemName.length(); j++) {
                if (newItemName.charAt(j) == 32) {
                } else if (newItemName.charAt(j) >=65 && newItemName.charAt(j) <=90){
                } else if (newItemName.charAt(j) >= 97 && newItemName.charAt(j) <= 122) {
                } else if (newItemName.charAt(j) >=48 && newItemName.charAt(j) <=57){
                } else {
                    showMainMenu(list);
                }
            }
            System.out.println("What is the price of the item? Type 0 if you don't know.");
            String newItemPrice = sc.nextLine();
            if ((validateDouble(newItemPrice) < 0 ||(validateDouble(newItemPrice)) > 1000000000)){
                System.out.println("Price can not be negative or over 1,000,000,000. Try again. ");
                showMainMenu(list);
            }
            System.out.println("Which aisle is the item on? Type 0 if you don't know");
            String newItemAisle = sc.nextLine();
            if (validateInt(newItemAisle) < 0 || validateInt(newItemAisle) > 1000000000){
                System.out.println("Aisle can not be negative or over 1,000,000,000. Try again. ");
                showMainMenu(list);
            }
            Food newFood = new Food(newItemName, validateInt(newItemAisle), validateDouble(newItemPrice));
            System.out.println("Pick the slot on the list of your item" +
                    " (type \"Y\") or, just add it to the end by (typing \"N\")." +
                    " Other inputs will result in termination of the program. " +
                    "If you decided on \"0\" for the aisle, refrain from picking \"Y\", " +
                    "as it may cause you to re-input ");
            String listSlotDecision= sc.nextLine();


            if (listSlotDecision.equals("Y") || listSlotDecision.equals("y") ) {
                System.out.println("Where do you want to add the item?");
                String itemToAdd = sc.nextLine();
                if (validateInt(itemToAdd) > (list.shopList.size()+1) || validateInt(itemToAdd) < 1 ){
                    System.out.println("You may not add an item in a slot below 1." +
                            " If you wish to add to a slot at the end, press \"N\" when prompted.");
                    showMainMenu(list);
                }
                list.addToList(newFood, validateInt(itemToAdd) );
            } else if (listSlotDecision.equals("N") || listSlotDecision.equals("n") ){
                list.addToList(newFood);
            } else {
                showMainMenu(list);
            }
            showMainMenu(list);
        }else if (determinedAction.equals("sort")){
            list.sort();
            showMainMenu(list);
        }else if (determinedAction.equals("exit")){
            System.exit(1);
        }else {
            showMainMenu(list);
        }
    }

    public static int validateInt(String str){
        if (str.isEmpty()){
            System.out.println("Don't input empty strings!");
            System.exit(1);
        }
        for (int j =0; j<str.length(); j++){
            if (str.charAt(j) > 57 || str.charAt(j) < 48 ) {
                System.exit(1);
            }
        }
        int numToBeReturned = Integer.parseInt(str);
        return numToBeReturned;
    }
    public static double validateDouble(String str){
        if (str.isEmpty()){
            System.out.println("Don't input empty strings!");
            System.exit(1);
        }
        for (int j =0; j<str.length(); j++){
            if ((str.charAt(j) > 57 || str.charAt(j) < 48 )&& (str.charAt(j)!=46)) {
                System.exit(1);
            }
        }
        double numToBeReturned = Double.parseDouble(str);
        return numToBeReturned;
    }
}


