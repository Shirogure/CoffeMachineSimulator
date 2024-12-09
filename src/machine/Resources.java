package machine;

public class Resources {
    private int milk = 540;
    private int water = 400;
    private int coffeeBeans = 120;
    private int money = 550;
    private int cups = 9;
    private int coffeCount = 0;

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        if (milk >= 0) {
            this.milk = milk;
        } else {
            System.out.println("Milk amount cannot be negative!");
        }
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        if (water >= 0) {
            this.water = water;
        } else {
            System.out.println("Water amount cannot be negative!");
        }
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        if (coffeeBeans >= 0) {
            this.coffeeBeans = coffeeBeans;
        } else {
            System.out.println("Coffee beans amount cannot be negative!");
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money >= 0) {
            this.money = money;
        } else {
            System.out.println("Money amount cannot be negative!");
        }
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        if (cups >= 0) {
            this.cups = cups;
        } else {
            System.out.println("Cups amount cannot be negative!");
        }
    }

    public int getCoffeCount() {
        return coffeCount;
    }

    public void setCoffeCount(int coffeCount) {
        this.coffeCount = coffeCount;
    }
}
