package task2;

public class Configuration {

    public static  final String DB_USER_NAME = "sa";

    public static final String DB_PASSWORD = "";

    public static final  String DB_URL= "jdbc:h2:~/test";

    public static final String DB_DRIVER = "org.h2.Driver";

    public static final Integer DB_MAX_CONNECTIONS = 5;

    private static Configuration configuration = new Configuration();

    private Configuration(){}
    public static Configuration getInstance(){
        return configuration;
    }


}