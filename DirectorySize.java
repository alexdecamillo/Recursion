package TowerOfHanoi;
import java.io.File;
import java.util.Scanner;

public class DirectorySize {

	public static void main(String[] args) {
		System.out.print("Enter the directory: ");
		Scanner input = new Scanner(System.in);
		String dir = input.nextLine();
		System.out.println("The directory size is: " + fileSize(new File(dir)) + " bytes.");
		input.close();
	}

	static long fileSize(File file){
		long size = 0;
		
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(int i=0; files != null && i < files.length; i++){
				size += fileSize(files[i]);
			}
		}else{
			size += file.length();
		}
		
		return size;
	}
	
}
