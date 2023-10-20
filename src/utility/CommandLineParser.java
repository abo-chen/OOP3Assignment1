package utility;

/**
 * A utility class for parsing command-line arguments.
 * <p>
 * The parser can recognize the following options:
 * </p>
 * <ul>
 * <li>-f: Specifies the input file name and path.
 * <li>-t: Specifies the compare type which can be volume (v), height (h), or base area (a).
 * <li>-s: Specifies the sorting type which can be bubble (b), selection (s), insertion (i), merge (m), quick (q), or user's choice (z).
 * </ul>
 */
public class CommandLineParser {

	private String fileName;
	private String compareType;
	private String sortType;

    /**
     * Parses the given array of command-line arguments.
     *
     * @param args the array of command-line arguments.
     * @return true if all required arguments are present and valid; false otherwise.
     */
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

    /**
     * Gets the file name specified by the -f option.
     *
     * @return the file name or null if the -f option was not specified.
     */
	public String getFileName() {
		return fileName;
	}

    /**
     * Gets the compare type specified by the -t option.
     *
     * @return the compare type or null if the -t option was not specified.
     */
	public String getCompareType() {
		return compareType;
	}

    /**
     * Gets the sort type specified by the -s option.
     *
     * @return the sort type or null if the -s option was not specified.
     */
	public String getSortType() {
		return sortType;
	}

    /**
     * Prints the help message to the console, showing the usage of the command-line options.
     */
	public void showHelp() {
		System.out.println("Usage: java -jar sort.jar [-f file_name] [-t v|h|a] [-s b|s|i|m|q|z]");
		System.out.println("-f: Specifies the file name and path.");
		System.out.println("-t: Specifies the compare type (v: volume, h: height, a: base area).");
		System.out.println(
				"-s: Specifies the sorting type (b: bubble, s: selection, i: insertion, m: merge, q: quick, z: your choice).");
	}
}