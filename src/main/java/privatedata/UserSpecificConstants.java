package privatedata;

public class UserSpecificConstants {
	// Constants
	public static final String googleApplicationName = "";
	public static final String googleAPIKey = ""; //Google provided API key
	public static final String googleCustomSearchID = "";
	
	public static final String indriIndex = "data/indri_index";
	public static final String luceneIndex = "data/lucene_index";
	public static final String luceneSearchField = "text";
	public static final String indriResultsFilter = "#filrej(list.title #combine(%s))"; 
	public static final String luceneResultsFilter = " NOT title:*\\:*" + " NOT title:list*";
}
