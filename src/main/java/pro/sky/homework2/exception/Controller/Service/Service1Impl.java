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
//        return " Ваш логин : " + login;
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
/*Параметр Login содержит в себе только латинские буквы, цифры и знак подчеркивания.
Например, java_skypro_go. У параметра login есть ограничение по длине – он должен быть равен или меньше 20 символов.
 Если login длиннее 20 символов или содержит
в себе недопустимые символы, то необходимо выбросить исключение – WrongLoginException.*/