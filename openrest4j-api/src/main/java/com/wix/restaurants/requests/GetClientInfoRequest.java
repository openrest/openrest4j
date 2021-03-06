package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.authentication.model.User;

import java.util.LinkedHashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetClientInfoRequest extends Request {
	public static final String TYPE = "get_client_info";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetClientInfoRequest() {}
    
    public GetClientInfoRequest(String accessToken, User clientId, Set<String> organizationIds) {
    	this.accessToken = accessToken;
    	this.clientId = clientId;
    	this.organizationIds = organizationIds;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    /** Optional client-ID (defaults to requesting user if null). */
    @JsonInclude(Include.NON_NULL)
    public User clientId;
    
    /** Optional organization-ids for displaying ClientInfo.comments. */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> organizationIds = new LinkedHashSet<>();
}
