package de.uk.java;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		
		// Variablen für Spielende
		Player player = new Player(100, 1);
		
		// Scanner initialisieren für das einlesen des User Inputs
		Scanner input = new Scanner(System.in);

		// Start des Spiels, Namen definieren
		System.out.println("Willkommen im TextAdventure");
		System.out.println("Wähle einen Namen bevor das Spiel anfängt:");
		player.setName(input.nextLine()); // auf User-Input (neue Zeile) warten
		
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
				System.out.println(player.getName() + " begibt sich auf eine schwierige Reise!");
				break;
			case "show player":
				System.out.printf("Name: %s\nHealth: %s\nStrength: %s\n", player.getName(), player.getHealth(), player.getStrength());
				break;
			case "attack":
				Enemy enemy = new Enemy(10, 2);
				attackLoop : while (true) {
					if (enemy.getHealth() <= 0) {
						System.out.println("Der Gegner ist gestorben. Du hast gewonnen");
						break attackLoop;
					} else if (player.getHealth() <= 0) {
						System.out.println("Du bist gestorben");
						break attackLoop;
					}
					System.out.printf("Du greifst mit %s Stärke an.\n", player.getStrength());
					enemy.takeDamage(player.getStrength());
					TimeUnit.MILLISECONDS.sleep(500);
					System.out.printf("Der Gegner hat noch %s Leben.\n", enemy.getHealth());
					TimeUnit.MILLISECONDS.sleep(1000);
					System.out.printf("Der Gegner greift dich mit %s Stärke an.\n", enemy.getStrength());
					TimeUnit.MILLISECONDS.sleep(500);
					player.takeDamage(enemy.getStrength());
					System.out.printf("Du hast noch %s Leben.\n", player.getHealth());
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
