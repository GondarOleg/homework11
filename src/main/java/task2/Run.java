package task2;

import java.sql.SQLException;

public class Run {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CookieDAO cookieDAO = new CookieDAO();
        CookieDTO cookieDTO = new CookieDTO("Updated111Txt", 5);
        cookieDAO.updateData(cookieDTO);
        CookieDTO cookie = cookieDAO.getData(cookieDTO);
        System.out.println(cookie.getCookie());
        cookieDAO.deleteData(cookieDTO);
        cookieDTO.setCookie("InsertedText");
        cookieDAO.insertData(cookieDTO);
        //cookie = cookieDAO.getData(cookieDTO);
        //System.out.println(cookie.getCookie());
        System.out.println(cookieDAO.getData(cookieDTO).getCookie());

//        TestTread testTread1 = new TestTread(new CookieDTO("Tread11Cookie",111), cookieDAO);
//        TestTread testTread2 = new TestTread(new CookieDTO("Tread22Cookie",222), cookieDAO);
//        TestTread testTread3 = new TestTread(new CookieDTO("Tread33Cookie",333), cookieDAO);
//        TestTread testTread4 = new TestTread(new CookieDTO("Tread44Cookie",444), cookieDAO);
//        TestTread testTread5 = new TestTread(new CookieDTO("Tread55Cookie",555), cookieDAO);
//        TestTread testTread6 = new TestTread(new CookieDTO("Tread66Cookie",666), cookieDAO);
//        TestTread testTread7 = new TestTread(new CookieDTO("Tread77Cookie",777), cookieDAO);
//
//        testTread1.start();
//        testTread2.start();
//        testTread3.start();
//        testTread4.start();
//        testTread5.start();
//        testTread6.start();
//        testTread7.start();
//
//        try {
//            TimeUnit.SECONDS.sleep(35);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
    }
}
