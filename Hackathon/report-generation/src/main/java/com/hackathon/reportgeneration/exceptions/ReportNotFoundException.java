package com.hackathon.reportgeneration.exceptions;

public class ReportNotFoundException extends Exception {
    public ReportNotFoundException(Long id){
        super("Report With id "+id+" Not Found");
    }
}
