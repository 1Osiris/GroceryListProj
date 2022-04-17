import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class List {
    ArrayList<Food> shopList = new ArrayList<Food>();

    public List () {}

    //method to add a series of items on the list from an array
    public void addmulti (Food [] arr) {
        shopList.addAll(Arrays.asList(arr));
    }

    //methods to add a singular item to the shopping list from the front or into any position
    public void addToList (Food food) {
        shopList.add(food);
    }
    public void addToList (Food food, int index) {
        index -= 1;
        shopList.add(index,food);
    }


    //method to remove a singular item off the shopping list
    public void removeOffOfList (int x) {
        x -= 1;
        shopList.remove(x);
    }

    //method to switch two items
    public void shiftItem(int ogPos, int newPos) {
        ogPos -= 1; //inputs will be from user who input the first index as
        newPos -= 1;// 1, not 0 and so on. This just corrects it back.
        ArrayList<Food> listCopy = (ArrayList<Food>) shopList.clone(); //copy arrlist to help
        //modify current arrlist.
        if (newPos > ogPos) {
            for (int i = 0; i < shopList.size(); i++) {
                if (i > ogPos && newPos > i) {
                    listCopy.set(i-1,shopList.get(i));
                }
                if (i == newPos) {
                    listCopy.set(i-1,shopList.get(i));
                    listCopy.set(newPos, shopList.get(ogPos));
                }
                if (i > newPos) {
                    break;
                }
            }
        }
        if (ogPos > newPos) {
            for (int i = 0; i < shopList.size(); i++) {
                if (i >= newPos && ogPos > i) {
                    listCopy.set(i+1, shopList.get(i));
                }
                if (i == ogPos) {
                    listCopy.set(newPos, shopList.get(ogPos));
                }
            }
        }
        shopList = listCopy;
    }

    //method to swap two items on the shopping list
    public void swapItem (int x, int y) {
        x -= 1;
        y -= 1;
        Food swapItem1 = shopList.get(x);
        Food swapItem2 = shopList.get(y);
        shopList.set(x,swapItem2);
        shopList.set(y,swapItem1);
    }

    public void sort () {
        Collections.sort(shopList);
    }

    //method to print the shopping list.
    public void printList () {
        for (Food food: this.shopList) {
            System.out.println(food.name + " " + food.price + " " + food.aisleNum);
        }
    }
}
