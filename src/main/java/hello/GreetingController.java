package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/greeting/time")
    public Greeting greetingTime(@RequestParam(value="hour", defaultValue="13") int hour) {

        if(hour >=6 && hour <=11){
            return new Greeting(counter.incrementAndGet(),"Bom dia");
        }

        else if(hour >= 12 && hour <= 19){
            return new Greeting(counter.incrementAndGet(),"Boa tarde");
        }

        else if(hour >= 20 && hour <= 23){
            return new Greeting(counter.incrementAndGet(),"Boa noite");              
    }
    else{
        return new Greeting(counter.incrementAndGet(),"Deu erro, compile denovo"); 
    }

}
}