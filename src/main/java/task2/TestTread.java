package task2;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by O.Gondar on 11.05.2016.
 */
public class TestTread extends Thread {

    private static final Logger logger = Logger.getLogger(String.valueOf(CookieDAO.class));
    private CookieDTO cookieDTO;
    private CookieDAO cookieDAO;

    public TestTread(CookieDTO cookieDTO, CookieDAO cookieDAO) {
        this.cookieDTO = cookieDTO;
        this.cookieDAO = cookieDAO;
    }

    @Override
    public void run() {
        cookieDAO.updateData(cookieDTO);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            org.apache.log4j.BasicConfigurator.configure();
            logger.error(e);
            Thread.currentThread().interrupt();
        }
        System.out.println(cookieDAO.getData(cookieDTO).getCookie());
    }
}
