package server;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class StartServer {

    private static final Logger logger = Logger.getLogger("");

    public static void main(String[] args) {
        try {
//            Handler fileHandler = new FileHandler("log_%g.txt", 20 * 1024, 20, true);
//            fileHandler.setFormatter(new SimpleFormatter());
//            logger.addHandler(fileHandler);
            LogManager manager = LogManager.getLogManager();
            manager.readConfiguration(new FileInputStream("logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Server();
    }
}
