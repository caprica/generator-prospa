package <%= packageName %>.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import <%= packageName %>.domain.User;
import <%= packageName %>.service.UserService;

/**
 * An example web service API controller.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<User> users() {
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        }
        return userService.users();
    }

    @RequestMapping(value = "/api/users/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> user(@PathVariable("username") String username) {
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        }
        return userService.user(username)
            .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
