package br.com.cambio.controller;

import br.com.cambio.model.Cambio;
import br.com.cambio.repository.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    private Environment env;

    @Autowired
    private CambioRepository repository;


    //    http://localhost:8000/cambio-service/5/USD/BRL
    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount") final BigDecimal amount,
                            @PathVariable("from") final String from,
                            @PathVariable("to") final String to) {

        final var cambio = this.repository.findFromAndTo(from, to);
        if (cambio == null) {
            throw new RuntimeException("Currency Unsupported");
        }
        cambio.setEnvironment(this.env.getProperty("local.server.port"));
        final BigDecimal conversionFactor = cambio.getConversionFactor();
        cambio.setConvertedValue(conversionFactor.multiply(amount).setScale(2, RoundingMode.CEILING));

        return cambio;
    }

}
