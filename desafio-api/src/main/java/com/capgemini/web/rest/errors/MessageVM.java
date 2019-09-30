package com.capgemini.web.rest.errors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageVM implements Serializable {

    private String message;

    private List<?> data;

    public MessageVM(String message) {
        this.message = message;
    }

    public MessageVM(String message, List<?> data) {
        this.message = message;
        this.data = data;
    }

    public MessageVM(String message, Object data) {
        this.message = message;
        List<Object> list = new ArrayList<>();
        list.add(data);
        this.data = list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
