package az.edu.turing.tinderapplication.exception.handler;

import az.edu.turing.tinderapplication.domain.model.LoginRequest;
import az.edu.turing.tinderapplication.exception.InvalidUserException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUserException.class)
    public String handleInvalidUserException(InvalidUserException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }
}
