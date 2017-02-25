package com.gro.model.DTO;

public final class RESTResponse<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }
}