package pro.sky.homework2.exception.Controller.Service;

import org.springframework.stereotype.Service;
import pro.sky.homework2.exception.Controller.Exceptions.WrongLoginException;
import pro.sky.homework2.exception.Controller.Exceptions.WrongPasswordException;


@Service
public class Service1Impl implements Service1 {


    public String cheсkloginPasswordAndConfirmPassword(String login, String password, String confirmPassword) {
        if (!login.contains("_") || !login.matches("\\w+") || login.length() > 20) {

            throw new WrongLoginException("Логин содержит недопустимые символы или их длина больше 20 символов");

        } else if (!password.contains("_") || !password.matches("\\w+") || password.length() > 20) {

            throw new WrongPasswordException("Пароль содержит недопустимые символы или их длина больше 20 символов ");


        } else if (!password.equals(confirmPassword)) {

            throw new WrongPasswordException("Символы в паролях не совпадают");
        }


        return login + " " + password + " " + confirmPassword;
    }
}



