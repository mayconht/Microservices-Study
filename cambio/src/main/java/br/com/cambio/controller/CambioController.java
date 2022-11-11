package br.com.cambio.controller;

import br.com.cambio.model.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("cambio-service")
public class CambioController {
    
    @Autowired
    Environment env;

    //    http://localhost:8000/cambio-service/5/USD/BRL
    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount") final BigDecimal amount,
                            @PathVariable("from") final String from,
                            @PathVariable("to") final String to) {

        return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, this.env.getProperty("local.server.port"));
    }

}
