package de.uk.java;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		
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
		gameloop : while (true) {
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
			case "attack":
				int enemyHealth = 10;
				int enemyStrength = 2;
				attackLoop : while (true) {
					if (enemyHealth <= 0) {
						System.out.println("Der Gegner ist gestorben. Du hast gewonnen");
						break attackLoop;
					} else if (playerHealth <= 0) {
						System.out.println("Du bist gestorben");
						break attackLoop;
					}
					System.out.printf("Du greifst mit %s Stärke an.\n", playerStrength);
					enemyHealth -= playerStrength;
					TimeUnit.MILLISECONDS.sleep(500);
					System.out.printf("Der Gegner hat noch %s Leben.\n", enemyHealth);
					TimeUnit.MILLISECONDS.sleep(1000);
					System.out.printf("Der Gegner greift dich mit %s Stärke an.\n", enemyStrength);
					TimeUnit.MILLISECONDS.sleep(500);
					playerHealth -= enemyStrength;
					System.out.printf("Du hast noch %s Leben.\n", playerHealth);
					TimeUnit.MILLISECONDS.sleep(1000);
				}
				break;
			case "exit":
				System.out.println("Schade, dass du jetzt schon gehen möchtest. Tschüss!");
				break gameloop;
			default:
				System.out.println("Den Befehl gibt es nicht!");
			}
		}
	}

}
