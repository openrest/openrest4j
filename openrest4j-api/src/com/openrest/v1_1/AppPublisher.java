package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** AppStore application publisher .*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppPublisher implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public AppPublisher(String title, String url, String copyright, Certificate androidCertificate, Certificate iosCertificate, Certificate iosPrivateKey) {
    	this.title = title;
    	this.url = url;
    	this.copyright = copyright;
    	this.androidCertificate = androidCertificate;
    	this.iosCertificate = iosCertificate;
    	this.iosPrivateKey = iosPrivateKey;
    }
    
    /** Default constructor for JSON deserialization. */
    public AppPublisher() {}
    
    @Override
	public Object clone() {
    	return new AppPublisher(title, url, copyright,
    			((androidCertificate != null) ? (Certificate) androidCertificate.clone() : null),
    			((iosCertificate != null) ? (Certificate) iosCertificate.clone() : null),
    			((iosPrivateKey != null) ? (Certificate) iosPrivateKey.clone() : null));
	}
    
    @JsonInclude(Include.NON_NULL)
    public String title;
    
    @JsonInclude(Include.NON_NULL)
    public String url;
    
    @JsonInclude(Include.NON_NULL)
    public String copyright;

    @JsonInclude(Include.NON_NULL)
    public Certificate androidCertificate;
    
    @JsonInclude(Include.NON_NULL)
    public Certificate iosCertificate;
    
    @JsonInclude(Include.NON_NULL)
    public Certificate iosPrivateKey;
}
