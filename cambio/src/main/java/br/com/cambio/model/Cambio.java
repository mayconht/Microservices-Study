package br.com.cambio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Cambio implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_currency", nullable = false, length = 3)
    private String from;

    @Column(name = "to_currency", nullable = false, length = 3)
    private String to;

    @Column(nullable = false)
    private BigDecimal conversionFactor;

    @Transient
    private BigDecimal convertedValue;

    @Transient
    private String environment;


    public Cambio() {
    }

    public Cambio(final Long id, final String from, final String to, final BigDecimal conversionFactor, final BigDecimal convertedValue, final String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.environment = environment;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public BigDecimal getConversionFactor() {
        return this.conversionFactor;
    }

    public void setConversionFactor(final BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public BigDecimal getConvertedValue() {
        return this.convertedValue;
    }

    public void setConvertedValue(final BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(final String environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "Cambio{" +
                "id=" + this.id +
                ", from='" + this.from + '\'' +
                ", to='" + this.to + '\'' +
                ", conversionFactor=" + this.conversionFactor +
                ", convertedValue=" + this.convertedValue +
                ", environment='" + this.environment + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Cambio cambio = (Cambio) o;
        return Objects.equals(this.id, cambio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
