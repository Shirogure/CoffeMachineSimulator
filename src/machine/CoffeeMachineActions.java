package machine;

import java.util.Scanner;

public class CoffeeMachineActions{
    private final Resources resources;
    private final Scanner sc = new Scanner(System.in);

    public CoffeeMachineActions(Resources resources){
        this.resources = resources;
    }
    public void buyAction() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = sc.next();

        int requiredWater = 0, requiredMilk = 0, requiredCoffeeBeans = 0, cost = 0;

        switch (choice) {
            case "1" -> {
                requiredWater = 250;
                requiredMilk = 0;
                requiredCoffeeBeans = 16;
                cost = 4;
            }
            case "2" -> {
                requiredWater = 350;
                requiredMilk = 75;
                requiredCoffeeBeans = 20;
                cost = 7;
            }
            case "3" -> { // Cappuccino
                requiredWater = 200;
                requiredMilk = 100;
                requiredCoffeeBeans = 12;
                cost = 6;
            }
            case "back" -> {
                return;
            }
            default -> {
                System.out.println("Invalid input");
                return;
            }
        }

        if (!checkResources(requiredWater, requiredMilk, requiredCoffeeBeans)) return;

        resources.setWater(resources.getWater() - requiredWater);
        resources.setMilk(resources.getMilk() - requiredMilk);
        resources.setCoffeeBeans(resources.getCoffeeBeans() - requiredCoffeeBeans);
        resources.setCups(resources.getCups() - 1);
        resources.setMoney(resources.getMoney() + cost);

        System.out.println("I have enough resources, making you a coffee!");
    }

    public void fillAction() {
        System.out.println("Write how many ml of water you want to add:");
        resources.setWater(resources.getWater() + sc.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        resources.setMilk(resources.getMilk() + sc.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:");
        resources.setCoffeeBeans(resources.getCoffeeBeans() + sc.nextInt());
        System.out.println("Write how many disposable cups you want to add:");
        resources.setCups(resources.getCups() + sc.nextInt());
    }

    public void takeAction() {
        System.out.printf("I gave you %d$%n", resources.getMoney());
        resources.setMoney(0);
    }

    public void remainingAction() {
        System.out.printf("""
                        The coffee machine has:
                        %d ml of water
                        %d ml of milk
                        %d g of coffee beans
                        %d disposable cups
                        %d$ of money%n""",
                resources.getWater(),
                resources.getMilk(),
                resources.getCoffeeBeans(),
                resources.getCups(),
                resources.getMoney());
    }

    private boolean checkResources(int water, int milk, int coffeeBeans) {
        if (resources.getWater() < water) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (resources.getMilk() < milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (resources.getCoffeeBeans() < coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (resources.getCups() < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }

    public void cleanAction() {
        resources.setCoffeCount(0);
    }
}
