public class Food implements Comparable<Food> {
    double price;
    String name;
    int aisleNum;
    public Food () {}
    public Food (String name,  int aisleNum, double price) {
        this.aisleNum = aisleNum;
        this.name = name;
        this.price = price;
    }

    @Override public int compareTo(Food comparestu)
    {
        int compareage
                = ((Food)comparestu).aisleNum;
        return this.aisleNum - compareage;
    }

}
