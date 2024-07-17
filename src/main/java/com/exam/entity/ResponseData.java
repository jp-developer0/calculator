package com.exam.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData {
    Double output;
    public ResponseData(Double value) {
        this.output = value;
    }
}
