package com.susu.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "user", createIndex = false)
public class UserDTO {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String data;
}
