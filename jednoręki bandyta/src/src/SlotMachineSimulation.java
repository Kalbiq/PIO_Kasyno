//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Component;
import java.util.Random;
import javax.swing.JOptionPane;

public class SlotMachineSimulation {
    public SlotMachineSimulation() {
    }

    public static void main(String[] args) {
        Random random = new Random();
        String[] slots = new String[]{"Cherry", "Melon", "Watermelon", "Strawberry", "Orange"};
        int[] simulationOutput = new int[]{-1, -1, -1};
        String play = "y";
        String userStringInput = JOptionPane.showInputDialog("Wprowadź kwotę: ");

        String stringSimulationoutput;
        for(int userAccount = Integer.parseInt(userStringInput); play.equals("y"); play = JOptionPane.showInputDialog((Component)null, stringSimulationoutput + "  , twój stan konta: " + userAccount + "$\n\n\n Chcesz zagrać jeszcze raz(y/n)?")) {
            userAccount -= 6;
            String message;
            if (userAccount < 0) {
                message = "Skończyły ci się pieniądze";
                JOptionPane.showMessageDialog((Component)null, message);
                break;
            }

            stringSimulationoutput = "";
            message = "";
            userAccount -= 3;

            for(int i = 0; i < 3; ++i) {
                simulationOutput[i] = random.nextInt(5);
                stringSimulationoutput = stringSimulationoutput + "[" + slots[simulationOutput[i]] + "]    ";
            }

            if (simulationOutput[0] == simulationOutput[1] && simulationOutput[0] == simulationOutput[2]) {
                message = "Wygrałeś 10$";
                userAccount += 10;
            } else if (simulationOutput[0] != simulationOutput[1] && simulationOutput[0] != simulationOutput[2]) {
                if (simulationOutput[1] == simulationOutput[2]) {
                    message = "Wygrałeś 5$";
                    userAccount += 5;
                } else {
                    message = "Nic nie wygrałeś";
                }
            } else {
                message = "Wygrałeś 5$";
                userAccount += 5;
            }

            stringSimulationoutput = stringSimulationoutput + "\n" + message;
        }

    }
}

