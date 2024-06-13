package com.example.t1_0320220094_muhamadmukhasim;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String  routingKey = "MukhasimQeueu";

    private static final String exchange = "MukhasimExchange";

    @RequestMapping(value = "/kirimPesan", method = RequestMethod.POST)
    public DtoResponse kirimPesan(@RequestBody String pesan){
        rabbitTemplate.convertAndSend(exchange, routingKey, pesan);
        return new DtoResponse(200, "Pesan yang anda kirim ke RabbitMQ: " + pesan,"Suskes");
    }

}

