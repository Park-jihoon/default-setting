package sample.pohinian.springvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class SpringVueApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringVueApplication.class, args);
    }

    //TODO : RouterFunction 은 추후 따로 클래스를 만들어 모아둘 필요성이 있어보인다.
    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(EchoHandler echoHandler) {
        //TODO : 추후 EchoHandler 의 의미와 쓰임새를 파악할 필요가 있다.


        //route function 으로 해당 url 요청 시 해당 Handler 를 실행한다.
        return route(POST("/echo"), echoHandler::echo);
    }
}
