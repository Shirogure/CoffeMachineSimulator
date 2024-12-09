package machine;

import java.util.Scanner;

public class CoffeeMachine{
    public static void main(String[] args) {
        Resources resources = new Resources();
        CoffeeMachineActions actions = new CoffeeMachineActions(resources);

        Scanner sc = new Scanner(System.in);
        String action;

        do {
            if (resources.getCoffeCount() > 10) {
                System.out.println("I need cleaning!");
                action = sc.next();
                if (action.equals("clean")) {
                    actions.cleanAction();
                    System.out.println("I have been cleaned!");
                } else {
                    continue;
                }

            } else {
                resources.setCoffeCount(resources.getCoffeCount() + 1);
                System.out.println("Write action (buy, fill, take, clean, remaining, exit): ");
                action = sc.next();
                switch (action) {
                    case "buy" -> actions.buyAction();
                    case "fill" -> actions.fillAction();
                    case "take" -> actions.takeAction();
                    case "clean" -> actions.cleanAction();
                    case "remaining" -> actions.remainingAction();
                }
            }
        } while (!action.equals("exit"));

        sc.close();
    }
}
