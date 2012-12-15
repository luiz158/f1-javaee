/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.rs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
@Provider
public class F1ExceptionRestMapper implements ExceptionMapper<F1ExceptionRest> {

    /*
     * (non-Javadoc)
     * 
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    @Override
    public Response toResponse(F1ExceptionRest f1ExceptionRest) {
        String msg = "";
        if (f1ExceptionRest != null) {
            msg = f1ExceptionRest.getMessage();
        }
        return Response.ok(msg).status(f1ExceptionRest.getStatus()).build();
    }

}
