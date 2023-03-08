package com.marvel.api.entity;

public interface Auditable {

    Audit getAudit();

    void setAudit(Audit audit);
}
