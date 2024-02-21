package com.susu.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import co.elastic.clients.json.JsonpMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping("es")
@Slf4j
public class EsController {

    @Autowired
    private ElasticsearchOperations operations;

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Autowired
    private RestClient restClient;

    @Autowired
    private JsonpMapper mapper;

    /**
     * 索引
     */
    @GetMapping("createIndex")
    public ResponseEntity<String> createIndex() throws IOException {
        String index = "shopping";

        CreateIndexResponse createResponse = elasticsearchClient.indices().create(c -> c.index(index));
        log.info("======createIndex====== index: {}, {}", createResponse.index(), createResponse.acknowledged());

        GetIndexResponse geResponse = elasticsearchClient.indices().get(c -> c.index(index));
        log.info("======queryIndex====== result: {}", geResponse.result());

        DeleteIndexResponse deleteResponse = elasticsearchClient.indices().delete(c -> c.index(index));
        log.info("======deleteIndex====== result: {}", deleteResponse.acknowledged());

        return ResponseEntity.ok( index);
    }



}
