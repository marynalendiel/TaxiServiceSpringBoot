package com.taxiservicespring.controller.client;

import com.taxiservicespring.entity.User;
import com.taxiservicespring.service.impl.UserServiceImpl;
import com.taxiservicespring.util.DataValidator;
import com.taxiservicespring.util.PasswordEncryptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static com.taxiservicespring.util.constant.WebPage.*;

@Controller
public class SignUpController {
    private static final Logger LOGGER = LogManager.getLogger(SignUpController.class);
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/signup")
    public String getSignUp() {
        return SIGNUP_PAGE;
    }

    @PostMapping(value = "/signup")
    public String postSignUp(@RequestParam Map<String, String> userInfo) {
        LOGGER.info("SignUpController starts.");

        User user = userService.getUserByLogin(userInfo.get("login"));

        if (user == null) {
            user = new User();

            user.setFirstName(userInfo.get("first_name"));
            user.setLastName(userInfo.get("last_name"));
            user.setLogin(userInfo.get("login"));
            user.setPhoneNumber(userInfo.get("phone_number"));
            user.setEmail(userInfo.get("email"));
            user.setPassword(PasswordEncryptor.encrypt(userInfo.get("password")));

            //If the data was invalid, return to the error page with the appropriate message
            if (!DataValidator.checkData(user.getFirstName(), user.getLastName(), user.getLogin(), user.getPhoneNumber(),
                    user.getEmail(), userInfo.get("password"))) {
                LOGGER.error("Input data is wrong");

                return "redirect:/error?errorMessage=error.data";
            }

            LOGGER.info("New user -> " + user);
            userService.saveUser(user);
        }
        return "redirect:" + MAIN_PAGE;
    }


}
