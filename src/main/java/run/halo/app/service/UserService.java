package run.halo.app.service;

import run.halo.app.exception.NotFoundException;
import run.halo.app.model.entity.User;
import run.halo.app.model.params.UserParam;
import run.halo.app.service.base.CrudService;
import org.springframework.lang.NonNull;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * User service.
 *
 * @author johnniang
 */
public interface UserService extends CrudService<User, Integer> {

    /**
     * Login failure count key.
     */
    String LOGIN_FAILURE_COUNT_KEY = "login.failure.count";

    /**
     * Max login try count.
     */
    int MAX_LOGIN_TRY = 5;

    /**
     * Lock minutes.
     */
    int LOCK_MINUTES = 10;

    /**
     * Gets current user.
     *
     * @return an optional user
     */
    @NonNull
    Optional<User> getCurrentUser();

    /**
     * Gets user by username.
     *
     * @param username username must not be blank
     * @return an optional user
     */
    @NonNull
    Optional<User> getByUsername(@NonNull String username);

    /**
     * Gets non null user by username.
     *
     * @param username username
     * @return user info
     * @throws NotFoundException throws when the username does not exist
     */
    @NonNull
    User getByUsernameOfNonNull(@NonNull String username);

    /**
     * Gets user by email.
     *
     * @param email email must not be blank
     * @return an optional user
     */
    @NonNull
    Optional<User> getByEmail(@NonNull String email);

    /**
     * Gets non null user by email.
     *
     * @param email email
     * @return user info
     * @throws NotFoundException throws when the username does not exist
     */
    @NonNull
    User getByEmailOfNonNull(@NonNull String email);

    /**
     * Logins by username and password.
     *
     * @param key         username or email must not be blank
     * @param password    password must not be blank
     * @param httpSession http session must not be null
     * @return user info
     */
    @NonNull
    User login(@NonNull String key, @NonNull String password, @NonNull HttpSession httpSession);

    /**
     * Updates user password.
     *
     * @param oldPassword old password must not be blank
     * @param newPassword new password must not be blank
     * @param userId      user id must not be null
     * @return updated user detail
     */
    @NonNull
    User updatePassword(@NonNull String oldPassword, @NonNull String newPassword, @NonNull Integer userId);

    /**
     * Creates an user.
     *
     * @param userParam user param must not be null.
     * @param password  password must not be blank
     * @return created user
     */
    @NonNull
    User createBy(@NonNull UserParam userParam, @NonNull String password);
}