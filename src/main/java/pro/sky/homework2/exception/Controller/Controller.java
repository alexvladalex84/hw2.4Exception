package pro.sky.homework2.exception.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework2.exception.Controller.Exceptions.WrongLoginException;
import pro.sky.homework2.exception.Controller.Exceptions.WrongPasswordException;
import pro.sky.homework2.exception.Controller.Service.Service1;

@RestController

public class Controller {
    private Service1 service;

    public Controller(Service1 service) {
        this.service = service;
    }


    @GetMapping(path = "/userdata")
    public String handleLoginAndPassword(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {
        try {
            return service.cheсkloginPasswordAndConfirmPassword(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            e.printStackTrace();
            return " Login содержит недопустимые символы или их длина больше 20 символов";
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            return " Password содержит недопустимые символы или их длина больше 20 символов либо пароли не совпадают ";
        }

    }
}

