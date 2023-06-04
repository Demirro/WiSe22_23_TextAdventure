package de.uk.java;

import de.uk.java.entity.Player;
import de.uk.java.entity.enemies.Ork;
import de.uk.java.entity.item.Bomb;
import de.uk.java.entity.item.HealthPotion;
import de.uk.java.entity.item.StrengthPotion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

	// Scanner initialisieren für das einlesen des User Inputs
	
			Player player = new Player();
			
			Scanner input = new Scanner(System.in);

			public void start() throws InterruptedException {
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
				case "heal":
					new StrengthPotion(2).useItem(player);
					new HealthPotion(10).useItem(player);
					break;
				case "throw healing potion":
					HealthPotion hp = new HealthPotion(10);
					Ork ork1 = new Ork();
					hp.getThrown(ork1);
					System.out.println(ork1.getHealth());
					new Bomb().getThrown(ork1);
					System.out.println(ork1.getHealth());
					break;
				case "attack":
					Ork ork = new Ork();
					System.out.printf("Orc %s has appeard. It has %d health.", ork.getName(), ork.getHealth());
					attackLoop : while (true) {
						if (ork.getHealth() <= 0) {
							System.out.println("Der Gegner ist gestorben. Du hast gewonnen");
							break attackLoop;
						} else if (player.getHealth() <= 0) {
							System.out.println("Du bist gestorben");
							break attackLoop;
						}
						System.out.printf("Du greifst mit %s Stärke an.\n", player.getStrength());
						ork.takeDamage(player.getStrength());
						TimeUnit.MILLISECONDS.sleep(500);
						System.out.printf("Der Gegner hat noch %s Leben.\n", ork.getHealth());
						TimeUnit.MILLISECONDS.sleep(1000);
						System.out.printf("Der Gegner greift dich mit %s Stärke an.\n", ork.getStrength());
						TimeUnit.MILLISECONDS.sleep(500);
						player.takeDamage(ork.getStrength());
						System.out.printf("Du hast noch %s Leben.\n", player.getHealth());
						TimeUnit.MILLISECONDS.sleep(1000);
					}
					break;
				case "add inventory":
					System.out.println(player.getInventory());
					player.getInventory().addItem(new HealthPotion(10), 2);
					System.out.println(player.getInventory());
					break;
				case "save":
					saveGame();
					break;
				case "load":
					loadGame();
					break;
				case "exit":
					System.out.println("Schade, dass du jetzt schon gehen möchtest. Tschüss!");
					break gameloop;
				default:
					System.out.println("Den Befehl gibt es nicht!");
				}
			}
		}	
			public void saveGame() {
				FileOutputStream fileStream;
				try {
					fileStream = new FileOutputStream("saveGame.game");
					ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
					objectStream.writeObject(player);
					fileStream.close();
					objectStream.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
			public void loadGame() {
				FileInputStream fileStream;
				try {
					fileStream = new FileInputStream("saveGame.game");
					ObjectInputStream objectStream = new ObjectInputStream(fileStream);
					player = (Player) objectStream.readObject();
					fileStream.close();
					objectStream.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
}
