package TowerOfHanoi;
import java.util.Scanner;
public class TowerOfHanoi {

	public static void main(String[] args) {
		System.out.print("Enter the number of disks: ");
		Scanner input = new Scanner(System.in);
		int disks = input.nextInt();
		int[][] towers = new int[disks][3];
		
		// Fills the first tower
		for(int i=0; i < towers.length; i++){
			towers[i][0] = i+1;
		}
		
		printTower(towers);
		moveDisks(disks, 1, 2, 3, towers);
		input.close();
	}

	// Displays the towers
	static void printTower(int[][] towers){
		for(int i=0; i < towers.length; i++){
			for(int j=0; j < towers[0].length; j++){
				System.out.print(towers[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	// Moves disk in tower array
	static void towerMove(int[][] towers, int to, int from, int disk){
		int i = towers.length-1;
		do{
			if(towers[i][to-1] == 0){
				towers[i][to-1] = disk;
				for(int k=0; k < towers.length; k++){
					if(towers[k][from-1] != 0){
						towers[k][from-1] = 0;
						break;
					}
				}
				break;
			}
			else
				i--;
		}while(true);
		printTower(towers);
	}
	
	// Recursively moves disks around 
	static void moveDisks(int n, int from, int to, int aux, int[][] towers){
		if(n == 1){
			System.out.printf("Move disk %d from %d to %d\n", n, from, to);
			towerMove(towers, to, from, n);
		}
		else{
			moveDisks(n-1, from , aux, to, towers);
			System.out.printf("Move disk %d from %d to %d\n", n, from, to);
			towerMove(towers, to, from, n);
			moveDisks(n-1, aux, to, from, towers);
		}
	}
	
}
