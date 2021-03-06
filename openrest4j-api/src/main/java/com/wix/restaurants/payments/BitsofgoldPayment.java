package com.wix.restaurants.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.LinkedHashMap;
import java.util.Map;

/** Payment with a Bitcoin via Bits of Gold. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitsofgoldPayment extends Payment {
    public static final String TYPE = "il.co.bitsofgold";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public BitsofgoldPayment() {}

    public BitsofgoldPayment(Integer amount, Map<String, String> externalIds, String token) {
        super(amount, externalIds);
        this.token = token;
    }

    @Override
    public BitsofgoldPayment clone() {
        return cloneImpl();
    }

    @Override
    protected BitsofgoldPayment cloneImpl() {
        return new BitsofgoldPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                token);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BitsofgoldPayment that = (BitsofgoldPayment) o;

        return token != null ? token.equals(that.token) : that.token == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }

    /** Payment token. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String token;
}
