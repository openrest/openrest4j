package com.wix.restaurants.orders;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.IntegerInterval;

import java.io.Serializable;
import java.util.Objects;

/** Settings for future orders. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FutureOrdersInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public FutureOrdersInfo() {}

    public FutureOrdersInfo(Boolean disabled,
                            IntegerInterval delayMins) {
        this.disabled = disabled;
        this.delayMins = delayMins;
    }

    @Override
    public FutureOrdersInfo clone() {
        return new FutureOrdersInfo(disabled, delayMins);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FutureOrdersInfo that = (FutureOrdersInfo) o;
        return Objects.equals(disabled, that.disabled) &&
                Objects.equals(delayMins, that.delayMins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disabled, delayMins);
    }

    /** Whether or not future ordering is disabled. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean disabled = Boolean.FALSE;

    /**
     * Time interval in which future orders are allowed (minimum is mandatory, and non-negative).
     *
     * For example, min=1440 max=10080 means that future orders must be placed at least 1 day in advance,
     * and at most 7 days in advance.
     */
    @JsonInclude(Include.NON_NULL)
    public IntegerInterval delayMins = new IntegerInterval(30, 86400);
}
