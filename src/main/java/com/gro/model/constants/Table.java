package com.gro.model.constants;

public enum Table {
    MESSAGES("messages"),
    USERS("users");

    private final String tableName;

    Table(final String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}