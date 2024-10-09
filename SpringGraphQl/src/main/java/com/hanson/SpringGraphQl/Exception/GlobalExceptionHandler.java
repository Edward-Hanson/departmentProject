package com.hanson.SpringGraphQl.Exception;

import graphql.GraphQLError;
import graphql.GraphQLException;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler({GenericGraphQLException.class, GraphQLException.class})
    public GraphQLError handleGenericGraphQLException(GenericGraphQLException ex){
        return GraphQLError.newError().message(ex.getMessage()).build();
    }
}
