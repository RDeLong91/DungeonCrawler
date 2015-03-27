import java.util.Random;
import java.util.Scanner;


public class DungeonCrawler {

	public static void main(String[] args) {
		int damageToPlayer;
		int damageToMonster;
		int playerHealth = 20;
		int monsterHealth;
		int encounter;
		
		boolean monsterDead = false;
		
		while (monsterDead == false)
		{
		//Scanner keyboard = new Scanner(System.in);
		System.out.println("Advance through the dungeon\nRolling to see if"
				+ " you encounter a monster\n");
		
		encounter = encounter(); //Rolling the dice to see if monster
		System.out.println("Rolled: "+ encounter);
		
		if (encounter <= 3)
		{
			System.out.println("You encountered a monster...\nEnter 'A' to begin the assault");
			monsterHealth = monsterHealth();
			
			while (monsterHealth > 0)
			{
				damageToMonster = attacking();
				monsterHealth = monsterHealth - damageToMonster;
				System.out.println("Monster Health: " + monsterHealth);
				monsterDead = true;
			}
			
			if (monsterDead)
			{
				System.out.println("Level up!\n");
				playerHealth ++;
				monsterDead = false;
			}
			
			//Debugging Purposes Only
			/*System.out.println("Encounter!\nPress A to attack!");
			String attack = keyboard.next();
			if (attack.equals("A"))
			{
				System.out.println("Attacking!");
			}*/
		}
		
		}//End of while
		
		//System.out.println(encounter()); //Testing encounter for output
		
		
		
		
	}//End of main
	
	public static int encounter()
	{
		Random r = new Random();
		int encounter = r.nextInt(6);
		
		return encounter;
	}
	
	public static int attacking()
	{
		Scanner keyboard = new Scanner(System.in);
		String attack = keyboard.next();
		int damage = 0;
		if (attack.equals("A"))
		{
			Random r = new Random();
			damage = r.nextInt(101);
			if (damage == 0)
			{
				System.out.println("You missed!");
			}
			else
			{
				System.out.println("Nice you did: " + damage + " to the monster!");
			}
		}
		
		return damage;
	}
	
	public static int monsterHealth()
	{
		Random r = new Random();
		int hp = r.nextInt(101);
		
		return hp;
	}
}