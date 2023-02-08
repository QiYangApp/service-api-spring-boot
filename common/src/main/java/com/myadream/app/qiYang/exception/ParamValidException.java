package com.myadream.app.qiYang.exception;

import jakarta.validation.ConstraintViolationException;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author myadream
 */
public class ParamValidException extends BaseException {

    private List<FieldError> fieldErrors = new ArrayList<>();
    private static final long serialVersionUID = -716441870779206738L;

    @Override
    public String getMessage() {
        return fieldErrors.toString();
    }

    public ParamValidException(ConstraintViolationException violationException, MethodParameter[] methodParameters) {
        List<FieldError> errors = violationException.getConstraintViolations().stream().map(constraintViolation -> {
            PathImpl pathImpl = (PathImpl) constraintViolation.getPropertyPath();
            int paramIndex = pathImpl.getLeafNode().getParameterIndex();
            String paramName = methodParameters[paramIndex].getParameterName();
            assert paramName != null;
            return new FieldError("", paramName, constraintViolation.getMessage());
        }).collect(Collectors.toList());
        this.fieldErrors = errors;
    }


    public ParamValidException(BindException ex) {
        this.fieldErrors = bindExceptionToFieldError(ex);
    }

    public ParamValidException(List<FieldError> errors) {
        this.fieldErrors = errors;
    }

    private List<FieldError> bindExceptionToFieldError(BindException ex) {
        return ex.getFieldErrors().stream().map(f -> {
            return new FieldError(f.getObjectName(), f.getField(), Objects.requireNonNull(f.getDefaultMessage()));
        }).collect(Collectors.toList());
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}