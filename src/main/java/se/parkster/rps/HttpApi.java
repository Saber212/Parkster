package se.parkster.rps;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
public class HttpApi {


    @RequestMapping("/home")
    public StreamingResponseBody Home(Game game)
    {
        game.calculateResult(game.getPlayer_one(), game.getPlayer_two());
        System.out.println(game.getResult());
        StreamingResponseBody stream = out -> {
            out.write((game.getResult()).getBytes());
            out.flush();
        };
        return stream;
    }


}
