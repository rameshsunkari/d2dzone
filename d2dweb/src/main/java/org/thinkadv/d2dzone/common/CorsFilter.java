package org.thinkadv.d2dzone.common;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

/**
 * Servlet Filter implementation class SimpleCorsFilter
 */
public class CorsFilter implements ContainerResponseFilter {

    /**
     * Default constructor. 
     */
    public CorsFilter() {

    }

    /* (non-Javadoc)
     * @see com.sun.jersey.spi.container.ContainerResponseFilter#filter(com.sun.jersey.spi.container.ContainerRequest, com.sun.jersey.spi.container.ContainerResponse)
     */
    @Override
    public ContainerResponse filter(ContainerRequest req, ContainerResponse contResp) {
 
        ResponseBuilder resp = Response.fromResponse(contResp.getResponse());
        resp.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST,PUT, DELETE, OPTIONS");
 
        String reqHead = req.getHeaderValue("Access-Control-Request-Headers");
 
        if(null != reqHead && !reqHead.equals("")){
            resp.header("Access-Control-Allow-Headers", reqHead);
        }
 
        contResp.setResponse(resp.build());
            return contResp;
    }}

