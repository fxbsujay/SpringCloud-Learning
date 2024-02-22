package com.susu.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.util.Date;

@Data
@Document(indexName = "shopping")
public class CellPhoneDTO {

    @Id
    private String id;

    @Field(type = FieldType.Text, analyzer = "data")
    private String name;

    @Field(type = FieldType.Float)
    private Float price;


    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second)
    private Date createdDate;


}
