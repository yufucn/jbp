package yufu.jbp.user;

/**
 * @author wang
 */
public interface ICurrentUser {
    Boolean getAuthenticated();

    String getUserName();

    String getId();


}
