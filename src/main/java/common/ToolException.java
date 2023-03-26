package common;

import javax.ws.rs.core.Response;

public class ToolException extends Exception {

    private final Response.Status status;
    private Integer error;

    public ToolException(Response.Status status) {
        this.status = status;
    }

    public ToolException(Response.Status status, String msg) {
        super(msg);
        this.status = status;
    }

    public ToolException(Response.Status status, String msg, Integer error) {
        super(msg);
        this.status = status;
        this.error = error;
    }

    public Response.Status getStatus() {
        return status;
    }

    public Integer getError() {
        return error;
    }
}
