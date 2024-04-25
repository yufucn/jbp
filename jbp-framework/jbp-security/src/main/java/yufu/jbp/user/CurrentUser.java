package yufu.jbp.user;


import org.springframework.stereotype.Service;

/**
 * @author wang
 */
@Service
public class CurrentUser implements ICurrentUser {
    @Override
    public Boolean getAuthenticated() {
        return null;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }
}
