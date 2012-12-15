/**
 * Copyright (c) 2011-2012, IBSOFT.
 * All rights reserved.
 */
package br.com.ibsoft.f1.rs.exception;

import javax.ws.rs.core.Response.Status;

/**
 * 
 * @author lourenco
 * 
 * @since v1.0.0
 */
public class F1ExceptionRest extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int status = Status.INTERNAL_SERVER_ERROR.getStatusCode();

    public F1ExceptionRest() {
        super();
    }

    public F1ExceptionRest(String message, Throwable cause) {
        super(message, cause);
    }

    public F1ExceptionRest(String message, int status, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public F1ExceptionRest(String message) {
        super(message);
    }

    public F1ExceptionRest(int satatus) {
        super("");
        this.status = satatus;
    }

    public F1ExceptionRest(String message, int status) {
        super(message);
        this.status = status;
    }

    public F1ExceptionRest(Throwable cause) {
        super(cause);
    }

    public F1ExceptionRest(Throwable cause, int status) {
        super(cause);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
