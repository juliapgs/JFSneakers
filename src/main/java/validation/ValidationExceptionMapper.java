package validation;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

public class ValidationExceptionMapper implements ExceptionMapper<ValidationException>{

    @Override
    public Response toResponse(ValidationException exception) {
        ValidationError validationError = new ValidationError("400", "Erro de validação.");
        validationError.addFieldError(exception.getFieldName(), exception.getMessage());

        return Response.status(Status.BAD_REQUEST).entity(validationError).build();
 }
    
}
