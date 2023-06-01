package pro.sky.homework2.exception.Controller.Service;

import org.springframework.stereotype.Service;
import pro.sky.homework2.exception.Controller.Exceptions.WrongLoginException;
import pro.sky.homework2.exception.Controller.Exceptions.WrongPasswordException;

@Service
public class Service1Impl implements Service1 {

    public String cheekloginPasswordAndConfirmPassword(String login, String password, String confirmPassword) {
        if (!login.contains("_") || !login.matches("\\w+") || login.length() > 20) {
            try {
                throw new WrongLoginException();
            } catch (WrongLoginException e) {
                return " Login содержит недопустимые символы или их длина больше 20 символов,";
            }
        }
        else if (!password.contains("_") ||!password.matches("\\w+") ||  password.length() > 20) {
            try {
                throw new WrongPasswordException();
            } catch (WrongPasswordException e) {
                return " Password содержит недопустимые символы или их длина больше 20 символов ";
            }
        } else if (!password.equals(confirmPassword)) {
            try {
                throw new WrongPasswordException();
            } catch (WrongPasswordException e) {
                return " пароли не совпадают !";
            }
        }


        return login + " " + password + " " + confirmPassword;
    }

}
