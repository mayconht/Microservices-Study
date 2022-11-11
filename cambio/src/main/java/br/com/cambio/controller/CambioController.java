package br.com.cambio.controller;

import br.com.cambio.model.Cambio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    //    http://localhost:8000/cambio-service/5/USD/BRL
    @GetMapping(value = "/{amount}/{from}/{to}")
    public static Cambio getCambio(@PathVariable("amount") final BigDecimal amount,
                                   @PathVariable("from") final String from,
                                   @PathVariable("to") final String to) {
        
        return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, "PORT 8000");
    }

}
