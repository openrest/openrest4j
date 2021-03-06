package com.openrest.olo.charges.operators;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MaxOperator extends Operator {
    public static final String TYPE = "max";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public MaxOperator() {}
    
    public MaxOperator(List<Operator> operators, Map<String, String> properties) {
    	super(properties);
    	this.operators = operators;
    }
    
	@Override
	public Object clone() {
		return new MaxOperator(Operator.clone(operators),
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_DEFAULT)
    public List<Operator> operators = new LinkedList<Operator>();
}