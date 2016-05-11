package task2;

/**
 * Created by Oleg on 11.05.2016.
 */
public class CookieDTO {
    private int cookieId;
    private String cookie;

    public CookieDTO(String cookie, int cookieId) {
        this.cookie = cookie;
        this.cookieId = cookieId;
    }

    public int getCookieId() {
        return cookieId;
    }

    public void setCookieId(int cookieId) {
        this.cookieId = cookieId;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }
}
