import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDS03J_LogUnsanitized {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public void badLog(boolean loginSuccessful, String username){
        if (loginSuccessful) {
            logger.severe("User login succeeded for: " + username);
        } else {
            logger.severe("User login failed for: " + username);
        }
    }

    public void goodLog(boolean loginSuccessful, String username){
        if (loginSuccessful) {
            logger.severe("User login succeeded for: " + sanitizeUser(username));
        } else {
            logger.severe("User login failed for: " + sanitizeUser(username));
        }
    }

    public String sanitizeUser(String username) {
        return Pattern.matches("[A-Za-z0-9_]+", username) ? username : "unauthorized user";
    }

    public void goodLogSecureLogger(boolean loginSuccessful, String username) {
        Logger sanLogger = new SanitizedTextLogger(logger);

        if (loginSuccessful) {
            sanLogger.severe("User login succeeded for: " + username);
        } else {
            sanLogger.severe("User login failed for: " + username);
        }
    }

    private class SanitizedTextLogger extends Logger {
        Logger delegate;

        public SanitizedTextLogger(Logger delegate) {
            super(delegate.getName(), delegate.getResourceBundleName());
            this.delegate = delegate;
        }

        public String sanitize(String msg) {
            Pattern newline = Pattern.compile("\n");
            Matcher matcher = newline.matcher(msg);
            return matcher.replaceAll("\n  ");
        }

        public void severe(String msg) {
            delegate.severe(sanitize(msg));
        }

        // .. Other Logger methods which must also sanitize their log messages
    }
}