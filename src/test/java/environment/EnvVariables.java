package environment;


public class EnvVariables {

  public final static boolean LOCAL_USAGE = System.getProperty("local") !=null ? Boolean.valueOf(System.getProperty("local")) : true;

  public final static String DATABASE_URL = System.getProperty("dbURL") != null ? System.getProperty("dbURL") : "jdbc:mariadb://localhost:3306/kanboard";
  public final static String DATABASE_USER_NAME = "kanboard";
  public final static String DATABASE_PASSWORD = "kanboard-secret";

  public final static String DATABASE_ADMIN_USER = "admin";
  public final static int DATABASE_ADMIN_USER_ID = 1;
  public final static String DATABASE_ADMIN_TEMP_TOKEN = "admin";

  public static final String BASE_URL = System.getProperty("baseURL") !=null ? System.getProperty("baseURL") : "http://localhost:80";
  public static final String API_BASE_URL = BASE_URL + "/jsonrpc.php";
  public static final String API_AUTHENTICATION_HEADER = "X-API-Auth";
  public static final String JSONRPC = "2.0";

  public static final String BROWSER_NAME = System.getProperty("browser") !=null ? System.getProperty("browser") : "chrome";
  public static final boolean BROWSER_HEADLESS = System.getProperty("headless") !=null ? Boolean.valueOf(System.getProperty("headless")) : false;
  public static final String UI_BASE_URL = "http://localhost:80";

}
