package com.RBAC.RBAC.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse implements Serializable{

    private final Boolean status;

    private final String message;
}


