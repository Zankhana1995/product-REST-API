package com.centric.api.product.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

/**
 * The type AbstractBaseEntity
 *
 * @author Zankhana Patel
 */

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable {


    private static final long serialVersionUID = -8949316938062844496L;
    @ApiModelProperty(hidden=true)
    @Id
    @Column(name = "id", updatable = false)
    private String id;

    public AbstractBaseEntity() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof AbstractBaseEntity)) {
            return false;
        }
        AbstractBaseEntity other = (AbstractBaseEntity) obj;
        return getId().equals(other.getId());
    }
}
