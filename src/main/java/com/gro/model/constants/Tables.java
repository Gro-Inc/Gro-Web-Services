package com.gro.model.constants;

public enum Tables {
    MESSAGES("messages");

    private final String tableName;

    Tables(final String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}