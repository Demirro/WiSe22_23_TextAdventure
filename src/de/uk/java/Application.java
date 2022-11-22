package de.uk.java;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		// Variablen für Spielende
		int playerHealth = 100;
		int playerStrength = 1;
		String playerName = "";
		
		// Scanner initialisieren für das einlesen des User Inputs
		Scanner input = new Scanner(System.in);

		// Start des Spiels, Namen definieren
		System.out.println("Willkommen im TextAdventure");
		System.out.println("Wähle einen Namen bevor das Spiel anfängt:");
		playerName = input.nextLine(); // auf User-Input (neue Zeile) warten
		
		// Game-Loop starten, läuft ewig, es sei den man gibt exit ein
		while (true) {
			System.out.println("Gebe einen Befehl ein: ");

			// Kommandoeingabe abwarten
			String command = input.nextLine();

			/* Switch case für alle Kommandos
			 * Story für eine grundlegende Story
			 * show player zum Anzeigen Spielervariablen
			 * Exit, um das Spiel zu beenden
			 */
			switch (command.toLowerCase()) {
			case "story":
				System.out.println(playerName + " begibt sich auf eine schwierige Reise!");
				break;
			case "show player":
				System.out.printf("Name: %s\nHealth: %s\nStrength: %s\n", playerName, playerHealth, playerStrength);
				break;
			case "exit":
				System.out.println("Schade, dass du jetzt schon gehen möchtest. Tschüss!");
				System.exit(0);
			default:
				System.out.println("Den Befehl gibt es nicht!");
			}
		}
	}

}
