package org.springs.cassandra.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @PrimaryKey
    private int id;
    private String name;
}
