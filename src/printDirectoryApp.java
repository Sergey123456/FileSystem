import java.io.File;

public class printDirectoryApp {
	static int spacePerLevel = 6;

	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.err.println("usage: directory path");
			return;
		}
		
		File dir = new File(args[0]);
		if (!dir.exists()) {
			System.err.println(args[0] + "doesn't exist");
			return;
		}
		
		if (dir.isFile()) {
			System.out.println(args[0]);
		}
		
		printDir(dir, 0);
	}

	private static void printDir(File dir, int level) {
		File[] content = dir.listFiles();
		for (int i = 0; i < content.length; i++) {
			if (content[i].isDirectory()) {
				printDir(content[i], level + 1);
			}
			printShift(level);
			System.out.println(content[i]);
		}
	}
	
	private static void printShift(int level) {
		for (int i = 0; i < level * spacePerLevel; i++) {
			System.out.print(" ");
		}
	}

}
