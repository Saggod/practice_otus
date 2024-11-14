package extensions;

public class BrowserNotFoundException extends RuntimeException {

    public BrowserNotFoundException(String browserName) {
        super(String.format("Browser %s not supported", browserName));
    }

}
