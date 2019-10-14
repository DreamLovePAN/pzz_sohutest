package com.sohu.test.bean;


import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {
    private Integer dept_id;
    private String dept_name;
}
