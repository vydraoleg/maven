package com.it.academy.testing;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j;


@Getter
@Setter
@NoArgsConstructor
@Data
//@Log4j

@Builder

@Accessors(chain=true)

public class Cat {
    @NonNull
    private String name;
    private  int age;

}
