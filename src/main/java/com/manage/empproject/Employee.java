package com.manage.empproject;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String no;
    private String name;
    private String email;
}
