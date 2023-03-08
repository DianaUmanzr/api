package com.marvel.api.entity;

import java.time.LocalDateTime;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditListener {

    @PrePersist
    public void setCreatedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();

        if(audit == null) {
            audit = new Audit();
            auditable.setAudit(audit);
        }

        audit.setCreatedDate(LocalDateTime.now());
        audit.setCreatedBy(1L);
    }

    @PreUpdate
    public void setUpdatedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();

        audit.setLastModifiedDate(LocalDateTime.now());
        audit.setLastModifiedBy(1L);
    }
}
