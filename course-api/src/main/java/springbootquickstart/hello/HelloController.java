package springbootquickstart.hello;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
                                //This is only for a get request
    @RequestMapping("/hello")   //takes in a  parameter which is the url this method maps to.
    public String sayHi() {
        return "Hi!";
    }
}
