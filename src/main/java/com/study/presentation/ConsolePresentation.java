package com.study.presentation;

import com.study.domain.Game;

import java.util.Scanner;

public class ConsolePresentation {

    public static void main(String[] args) {
        System.out.println("This is cross/zero game\n" +
                "In order to make move choose:  1) field  2) figure to set.\n" +
                "Fields: A1 A2 A3\n" +
                "        B1 B2 B3\n" +
                "        C1 C2 C3\n" +
                "Figures: 0 = ZERO; 1 = CROSS");
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        for (int i = 0; i < 6; i++) {
            String[] arguments = scanner.nextLine().trim().split("\\s+");
            Integer figureType = Integer.parseInt(arguments[1].trim());

            game.move(arguments[0].trim(), figureType);
        }

        for (int i = 0; i < 10; i++) {
            game.undo();
        }

    }
}
