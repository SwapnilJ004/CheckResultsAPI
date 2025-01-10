package com.resultsDeclaration.Exceptions;

public class NoSuchElectionIdExistsException extends RuntimeException {

    public NoSuchElectionIdExistsException(){

    }

    public NoSuchElectionIdExistsException(String msg){
        super(msg);
    }
}
