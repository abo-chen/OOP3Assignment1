package utility;
public class CommandLineParser {

	private String fileName;
	private String compareType;
	private String sortType;

	public boolean parseArgs(String[] args) {
		for (int i = 0; i < args.length; i++) {
			String prefix = args[i].substring(0, Math.min(2, args[i].length())).toLowerCase();
			String value = args[i].length() > 2 ? args[i].substring(2) : null;

			switch (prefix) {
			case "-f":
				fileName = value;
				break;
			case "-t":
				compareType = value;
				break;
			case "-s":
				sortType = value;
				break;
			default:
				return false; // Invalid argument
			}
		}

		return !(fileName == null || compareType == null || sortType == null);
	}

	public String getFileName() {
		return fileName;
	}

	public String getCompareType() {
		return compareType;
	}

	public String getSortType() {
		return sortType;
	}

	public void showHelp() {
		System.out.println("Usage: java -jar sort.jar [-f file_name] [-t v|h|a] [-s b|s|i|m|q|z]");
		System.out.println("-f: Specifies the file name and path.");
		System.out.println("-t: Specifies the compare type (v: volume, h: height, a: base area).");
		System.out.println(
				"-s: Specifies the sorting type (b: bubble, s: selection, i: insertion, m: merge, q: quick, z: your choice).");
	}
}